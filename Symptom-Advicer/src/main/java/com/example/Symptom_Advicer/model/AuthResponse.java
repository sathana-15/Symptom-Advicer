package com.example.Symptom_Advicer.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;


@Data
@AllArgsConstructor
public class AuthResponse {
    private String message;
    private String token;
}
