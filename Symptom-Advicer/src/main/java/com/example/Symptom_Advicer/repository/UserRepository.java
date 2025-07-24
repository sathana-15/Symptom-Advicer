package com.example.Symptom_Advicer.repository;

import com.example.Symptom_Advicer.model.Patient;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UserRepository extends CrudRepository<Patient, Long> {
    Optional<Patient> findByUsername(String username);
    Optional<Patient> findByEmail(String email);
}


