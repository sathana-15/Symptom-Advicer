package com.example.Symptom_Advicer.model;


import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
public class AuthResponse {
    private String message;
    private String token;
}
