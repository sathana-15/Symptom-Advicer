package com.example.Symptom_Advicer.repository;

import com.example.Symptom_Advicer.model.Symptom;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface SymptomRepository extends CrudRepository<Symptom, Long> {
    List<Symptom> findByPatientId(Long patientId);
}
