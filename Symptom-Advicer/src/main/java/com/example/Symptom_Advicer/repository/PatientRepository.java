package com.example.Symptom_Advicer.repository;

import com.example.Symptom_Advicer.model.Patient;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface PatientRepository extends CrudRepository<Patient, Long> {

    Optional<Patient> findByEmail(String email);   // Spring will auto-generate SQL

    int countByEmail(String email);                // Works without @Query if method name matches
}
