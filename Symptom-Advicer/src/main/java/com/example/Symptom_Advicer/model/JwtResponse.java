package com.example.Symptom_Advicer.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;


@Data
//@AllArgsConstructor
public class JwtResponse {
    private String token;
    private String username;
    private String email;
    private String role;
    private Long patientId;


    public JwtResponse(String token, String username, String email, String role, Long patientId) {
        this.token = token;
        this.username = username;
        this.email = email;
        this.role = role;
        this.patientId = patientId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
