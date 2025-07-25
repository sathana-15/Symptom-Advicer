package com.example.Symptom_Advicer.service;

import com.example.Symptom_Advicer.model.AdviceResponse;
import com.example.Symptom_Advicer.model.Symptom;
import com.example.Symptom_Advicer.repository.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.Symptom_Advicer.service.AdviceService;

@Service
public class SymptomService {

    @Autowired
    private SymptomRepository symptomRepository;

    @Autowired
    private AdviceService adviceService;

    public AdviceResponse submitSymptomAndGetAdvice(Symptom symptom) {
        symptomRepository.save(symptom);
        return adviceService.getAdviceByKeyword(symptom.getDescription())
                .map(advice -> new AdviceResponse(advice.getAdviceText()))
                .orElse(new AdviceResponse("No advice available for this symptom."));
    }

    public List<Symptom> getSymptomsByPatient(Long patientId) {
        return symptomRepository.findByPatientId(patientId);
    }

    public List<Symptom> getAllSymptoms() {
        return (List<Symptom>) symptomRepository.findAll();
    }
}
