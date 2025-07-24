package com.example.Symptom_Advicer.controller;

import com.example.Symptom_Advicer.model.JwtResponse;
import com.example.Symptom_Advicer.model.LoginRequest;
import com.example.Symptom_Advicer.model.RegisterRequest;
import com.example.Symptom_Advicer.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Register a new user (patient/admin)
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequest registerRequest) {
        String message = authService.registerUser(registerRequest);
        return ResponseEntity.ok(message);
    }

    // Login and get JWT token
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest loginRequest) {
        JwtResponse jwtResponse = authService.authenticateUser(loginRequest);
        return ResponseEntity.ok(jwtResponse);
    }

}

