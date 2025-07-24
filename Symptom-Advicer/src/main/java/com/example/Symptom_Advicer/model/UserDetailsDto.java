package com.example.Symptom_Advicer.model;

import lombok.Data;

@Data
public class UserDetailsDto {
    private Long id;
    private String username;
    private String email;
    private String role;
}
