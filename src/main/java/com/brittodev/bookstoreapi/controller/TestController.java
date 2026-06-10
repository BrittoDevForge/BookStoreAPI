package com.brittodev.bookstoreapi.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/api/get")
    public ResponseEntity<String> getData() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Hello , this is end point");
    }
}
