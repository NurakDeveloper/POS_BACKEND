package com.pos.pos_backend.model.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    public User(Long userId, String username, Long employeeId, String password, String role, Date createdDate, Date updatedDate) {
        this.userId = userId;
        this.username = username;
        this.employeeId = employeeId;
        this.password = password;
        this.role = role;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    @Column(unique = true)
    private String username;
    private Long employeeId ;

    private String password;

    private String role;

    private Date createdDate;

    private Date updatedDate;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(() -> "ROLE_" + role); // Adds ROLE_ prefix to the role
        return authorities;
    }

    @Override
    public String getUsername() {
        return username; // Return the actual username
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Return true if account is not expired
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Return true if account is not locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Return true if credentials are not expired
    }

    @Override
    public boolean isEnabled() {
        return true; // Return true if the user is enabled
    }
}
