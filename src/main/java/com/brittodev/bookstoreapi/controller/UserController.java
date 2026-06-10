package com.brittodev.bookstoreapi.controller;


import com.brittodev.bookstoreapi.dto.requestDto.UserRequest;
import com.brittodev.bookstoreapi.dto.responseDto.UserResponse;
import com.brittodev.bookstoreapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(
            @RequestBody @Valid UserRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserRequest userRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.login(userRequest));
    }


}
