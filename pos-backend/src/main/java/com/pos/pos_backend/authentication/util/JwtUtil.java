package com.pos.pos_backend.authentication.util;

import com.pos.pos_backend.authentication.RoleAndPermission.RolePermissionConfig;

import com.pos.pos_backend.model.entity.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
     * Generates a JWT token including the user's role and permissions.
     *
     * @param user The user entity.
     * @return The generated JWT token.
     */
    public String generateTokenFromUser(User user) {
        Map<String, Object> claims = new HashMap<>();

        // Add user fields to claims
        claims.put("userId", user.getUserId());
        claims.put("username", user.getUsername());
        claims.put("employeeId", user.getEmployeeId());
        claims.put("role", user.getRole());

        // Add permissions to claims based on role
        List<String> permissions = RolePermissionConfig.getPermissionsByRole(user.getRole());
        claims.put("permissions", permissions);

        claims.put("createdDate", user.getCreatedDate());
        claims.put("updatedDate", user.getUpdatedDate());

        return createToken(claims, user.getUsername());
    }
//    public String extractRole(String token) {
//        final Claims claims = extractAllClaims(token);
//        return claims.get("role", String.class);
//    }
    public List<String> extractRoles(String token) {
        return extractClaim(token, claims -> claims.get("roles", List.class));
    }

    public List<String> extractPermissions(String token) {
        final Claims claims = extractAllClaims(token);
        return (List<String>) claims.get("permissions"); // Ensure "permissions" is a List<String>
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours expiration
                .signWith(getSigningKey())
                .compact();
    }

    /**
     * Validates a token and checks if it belongs to the provided username.
     *
     * @param token    The token to validate.
     * @param username The username to match.
     * @return True if valid, false otherwise.
     */
    public Boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    /**
     * Checks if the token has a specific permission.
     *
     * @param token              The token to validate.
     * @param requiredPermission The required permission.
     * @return True if the permission exists, false otherwise.
     */
    public boolean hasPermission(String token, String requiredPermission) {
        Claims claims = extractAllClaims(token);

        // Extract permissions from claims
        List<String> permissions = (List<String>) claims.get("permissions");

        return permissions != null && permissions.contains(requiredPermission);
    }
}
