package com.pos.pos_backend.authentication.controller;

import com.pos.pos_backend.authentication.RoleAndPermission.RolePermissionConfig;
import com.pos.pos_backend.authentication.request.AuthenticationResponse;
import com.pos.pos_backend.model.Dto.UserDTO;
import com.pos.pos_backend.authentication.util.JwtUtil;
import com.pos.pos_backend.model.entity.user.User;
import com.pos.pos_backend.model.entity.user.UserRequest;
import com.pos.pos_backend.model.entity.user.UserRespone;
import com.pos.pos_backend.repository.EmployeeRepository;
import com.pos.pos_backend.repository.UserRepository;
import com.pos.pos_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepo ;
    private JwtUtil jwtUtil;
    private UserService userService;
   private EmployeeRepository employeeRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequest authRequest) {
        try {
            // Authenticate the user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );

            // Find the user
            User findUser = userRepo.findByUsername(authRequest.getUsername());
            // Generate JWT token
            String token = jwtUtil.generateTokenFromUser(findUser);

            // Return the response
            return ResponseEntity.ok(new UserRespone("success", "ok", token, findUser.getUserId(), findUser.getRole(),employeeRepository.getEmployee(findUser.getEmployeeId()) ));
        } catch (AuthenticationException e) {
//            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
    @PostMapping("/authentication")
    public AuthenticationResponse authenticateUser(@RequestBody UserRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        User user = userRepo.findByUsername(authRequest.getUsername());
        // Generate token
        String token = jwtUtil.generateTokenFromUser(user);

        // Fetch permissions based on role
        List<String> permissions = RolePermissionConfig.getPermissionsByRole(user.getRole());

        // Build and return the response
        return new AuthenticationResponse(
                token,
                user.getUserId(),
                user.getUsername(),
                user.getRole(),
                employeeRepository.getEmployee(user.getEmployeeId()),
                permissions
        );
    }
    @PostMapping("register")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        UserDTO user = userService.createNewUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }
    @GetMapping("get-user/{id}")
    @PreAuthorize("hasAuthority('admin:get')")
    public ResponseEntity<?> getUserByEmployee(@PathVariable("id") Long employeeId){
        return ResponseEntity.ok(userService.listUserByEmployeeId(employeeId));
    }
}