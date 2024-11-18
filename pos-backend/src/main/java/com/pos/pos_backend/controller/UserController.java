package com.pos.pos_backend.controller;

import com.pos.pos_backend.model.user.UserRequest;
import com.pos.pos_backend.model.user.UserRespone;
import com.pos.pos_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("api/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    @PostMapping("login")
    public ResponseEntity<UserRespone> login(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(userService.userLogin(userRequest));
    }
}
