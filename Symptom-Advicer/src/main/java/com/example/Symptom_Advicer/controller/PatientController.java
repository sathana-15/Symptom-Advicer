package com.example.Symptom_Advicer.controller;

import com.example.Symptom_Advicer.model.Patient;
import com.example.Symptom_Advicer.model.PatientDto;
import com.example.Symptom_Advicer.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/patient")
@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping("/")
    public String welcome() {
        return "Welcome to Symptom Advicer!";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping("/patients/email/{email}")
    public Patient getPatientByEmail(@PathVariable String email) {
        return patientService.getPatientByEmail(email);
    }

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/patients")
    public String addPatient(@RequestBody PatientDto patientDto) {
        return patientService.addPatient(patientDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/patients/{id}")
    public String updatePatient(@PathVariable Long id, @RequestBody PatientDto patientDto) {
        return patientService.updatePatient(id, patientDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/patients/{id}")
    public String deletePatient(@PathVariable Long id) {
        return patientService.deletePatient(id);
    }
}
