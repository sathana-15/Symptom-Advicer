package com.example.Symptom_Advicer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles") // ✅ Correct JDBC table mapping
public class Roles {

    @Id // ✅ Correct for Spring Data JDBC
    private Long roleId;

    private String roleName; // No @Column — JDBC maps fields directly
}
