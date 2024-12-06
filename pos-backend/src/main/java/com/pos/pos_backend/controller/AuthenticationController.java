package com.pos.pos_backend.controller;

import com.pos.pos_backend.Dto.EmployeeDto;
import com.pos.pos_backend.Dto.UserDTO;
import com.pos.pos_backend.jwt.JwtUtil;
import com.pos.pos_backend.mapper.EmployeeMapper;
import com.pos.pos_backend.model.Employee;
import com.pos.pos_backend.model.user.User;
import com.pos.pos_backend.model.user.UserRequest;
import com.pos.pos_backend.model.user.UserRespone;
import com.pos.pos_backend.repository.EmployeeRepository;
import com.pos.pos_backend.repository.UserRepository;
import com.pos.pos_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

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
            if (findUser == null) {
                return ResponseEntity.status(404).body("User not found");
            }

            // Generate JWT token
            String token = jwtUtil.generateToken(authRequest.getUsername());

            // Return the response
            return ResponseEntity.ok(new UserRespone("success", "ok", token, findUser.getUserId(), findUser.getRole(), null));
        } catch (AuthenticationException e) {
//            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @PostMapping("create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        UserDTO user = userService.createNewUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }
}