package com.example.Symptom_Advicer.service;

import com.example.Symptom_Advicer.model.Patient;
import com.example.Symptom_Advicer.model.PatientDto;
import com.example.Symptom_Advicer.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    // Get all patients
    public List<Patient> getAllPatients() {
        return (List<Patient>) patientRepository.findAll();
    }

    // Get patient by ID
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + id));
    }

    // Get patient by email
    public Patient getPatientByEmail(String email) {
        return patientRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Patient not found with email: " + email));
    }

    // Add new patient using DTO
    public String addPatient(PatientDto dto) {
        if (patientRepository.countByEmail(dto.getEmail()) > 0) {
            return "Email already registered!";
        }

        Patient patient = new Patient();
        mapDtoToEntity(dto, patient);
        patientRepository.save(patient);
        return "Patient added successfully!";
    }

    // Update patient using DTO
    public String updatePatient(Long id, PatientDto dto) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);

        if (optionalPatient.isEmpty()) {
            return "Patient not found!";
        }

        Patient patient = optionalPatient.get();
        mapDtoToEntity(dto, patient);
        patient.setId(id); // Optional: ensures ID consistency
        patientRepository.save(patient);
        return "Patient updated successfully!";
    }

    // Delete patient by ID
    public String deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            return "Patient not found!";
        }
        patientRepository.deleteById(id);
        return "Patient deleted successfully!";
    }

    // Check if email exists
    public boolean existsByEmail(String email) {
        return patientRepository.countByEmail(email) > 0;
    }


    // Map DTO to Entity
    private void mapDtoToEntity(PatientDto dto, Patient patient) {
        patient.setUsername(dto.getUsername());
        patient.setEmail(dto.getEmail());
        patient.setPassword(dto.getPassword());
        patient.setRoles(dto.getRole());
        patient.setFullName(dto.getFullName());
        patient.setGender(dto.getGender());
        patient.setAge(dto.getAge());
        patient.setPhone(dto.getPhone());
        patient.setAddress(dto.getAddress());
    }
    }


