package com.example.Symptom_Advicer.controller;

import com.example.Symptom_Advicer.model.AdviceResponse;
import com.example.Symptom_Advicer.model.Symptom;
import com.example.Symptom_Advicer.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/symptoms")
public class SymptomController {

    @Autowired
    private SymptomService symptomService;

    @PostMapping("/submit")
    public AdviceResponse submitSymptom(@RequestBody Symptom symptom) {
        return symptomService.submitSymptomAndGetAdvice(symptom);
    }

    @GetMapping("/patient/{patientId}")
    public List<Symptom> getSymptomsByPatient(@PathVariable Long patientId) {
        return symptomService.getSymptomsByPatient(patientId);
    }

    @GetMapping
    public List<Symptom> getAllSymptoms() {
        return symptomService.getAllSymptoms();
    }
}
