package com.example.Symptom_Advicer.service;

import com.example.Symptom_Advicer.model.Patient;
import com.example.Symptom_Advicer.model.PatientDto;
import com.example.Symptom_Advicer.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Patient> getAllPatients() {
        return (List<Patient>) patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + id));
    }

    public Patient getPatientByEmail(String email) {
        return patientRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Patient not found with email: " + email));
    }

    public String addPatient(PatientDto dto) {
        if (patientRepository.countByEmail(dto.getEmail()) > 0) {
            return "Email already registered!";
        }

        Patient patient = new Patient();
        mapDtoToEntity(dto, patient);
        patientRepository.save(patient);
        return "Patient added successfully!";
    }

    public String updatePatient(Long id, PatientDto dto) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);

        if (optionalPatient.isEmpty()) {
            return "Patient not found!";
        }

        Patient patient = optionalPatient.get();
        mapDtoToEntity(dto, patient);
        patient.setId(id);
        patientRepository.save(patient);
        return "Patient updated successfully!";
    }

    public String deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            return "Patient not found!";
        }
        patientRepository.deleteById(id);
        return "Patient deleted successfully!";
    }

    public boolean existsByEmail(String email) {
        return patientRepository.countByEmail(email) > 0;
    }

    private void mapDtoToEntity(PatientDto dto, Patient patient) {
        patient.setUsername(dto.getUsername());
        patient.setEmail(dto.getEmail());


        patient.setPassword(passwordEncoder.encode(dto.getPassword()));

        patient.setRoles(dto.getRoles());
        patient.setFullName(dto.getFullName());
        patient.setGender(dto.getGender());
        patient.setAge(dto.getAge());
        patient.setPhone(dto.getPhone());
        patient.setAddress(dto.getAddress());
    }
}
