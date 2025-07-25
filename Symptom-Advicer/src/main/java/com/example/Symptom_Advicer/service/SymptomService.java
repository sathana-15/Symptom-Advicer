package com.example.Symptom_Advicer.service;

import com.example.Symptom_Advicer.model.Symptom;
import com.example.Symptom_Advicer.repository.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomService {

    @Autowired
    private SymptomRepository symptomRepository;

    public Symptom submitSymptom(Symptom symptom) {
        return symptomRepository.save(symptom);
    }

    public List<Symptom> getSymptomsByPatient(Long patientId) {
        return symptomRepository.findByPatientId(patientId);
    }

    public List<Symptom> getAllSymptoms() {
        return (List<Symptom>) symptomRepository.findAll();
    }
}
