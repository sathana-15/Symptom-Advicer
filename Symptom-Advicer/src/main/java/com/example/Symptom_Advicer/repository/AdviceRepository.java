package com.example.Symptom_Advicer.repository;

import com.example.Symptom_Advicer.model.Advice;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface AdviceRepository extends CrudRepository<Advice, Long> {
    Optional<Advice> findBySymptomKeywordIgnoreCase(String symptomKeyword);
}
