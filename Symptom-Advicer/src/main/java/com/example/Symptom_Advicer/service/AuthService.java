package com.example.Symptom_Advicer.service;

import com.example.Symptom_Advicer.jwt.JwtTokenProvider;
import com.example.Symptom_Advicer.model.*;
import com.example.Symptom_Advicer.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    public String registerUser(RegisterRequest request) {
        try {
            System.out.println("Received registration request: " + request);

            if (patientRepository.countByEmail(request.getEmail()) > 0) {
                return "Email already registered!";
            }

            Patient patient = new Patient();
            patient.setUsername(request.getUsername());
            patient.setEmail(request.getEmail());


            patient.setPassword(passwordEncoder.encode(request.getPassword()));

            patient.setRoles(request.getRoles());
            patient.setFullName(request.getFullName());
            patient.setGender(request.getGender());
            patient.setAge(request.getAge());
            patient.setPhone(request.getPhone());
            patient.setAddress(request.getAddress());

            patientRepository.save(patient);
            return "User registered successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Internal error: " + e.getMessage();
        }
    }



    public JwtResponse authenticateUser(LoginRequest loginRequest) {
        System.out.println(" Login Email: " + loginRequest.getEmail());
        System.out.println("Login Password: " + loginRequest.getPassword());


        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );


        System.out.println("Authentication: " + authentication);
        System.out.println("Principal: " + authentication.getPrincipal());
        System.out.println("Authorities: " + authentication.getAuthorities());


        Patient patient = patientRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Patient not found!"));


        String token = jwtTokenProvider.generateToken(authentication);

        System.out.println("Token generated: " + token);
        System.out.println("Username: " + patient.getUsername());
        System.out.println("Email: " + patient.getEmail());
        System.out.println("Role: " + patient.getRoles());

        return new JwtResponse(
                token,
                patient.getUsername(),
                patient.getEmail(),
                patient.getRoles()
        );
    }


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


        patient.setPassword(passwordEncoder.encode(dto.getPassword()));

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


        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            patient.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

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


    private void mapDtoToEntity(PatientDto dto, Patient patient) {
        patient.setUsername(dto.getUsername());
        patient.setEmail(dto.getEmail());
        patient.setRoles(dto.getRoles());
        patient.setFullName(dto.getFullName());
        patient.setGender(dto.getGender());
        patient.setAge(dto.getAge());
        patient.setPhone(dto.getPhone());
        patient.setAddress(dto.getAddress());
    }
}
