package com.example.Symptom_Advicer.controller;

import com.example.Symptom_Advicer.model.Patient;
import com.example.Symptom_Advicer.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/patient")
@RestController
public class PatientController {
    @Autowired
    PatientService hws;

    @GetMapping
    public List<Patient> getMethod(){
        return hws.getMethod();
    }

    @GetMapping("/{std_id}")
    public Patient getMethodById(@PathVariable int std_id){
        return hws.getMethodById(std_id);
    }


    @PostMapping
    public String postMethod(@RequestBody Patient s){
        return hws.postMethod(s);
    }


    @PutMapping
    public String putMethod(@RequestBody Patient s1){
        return hws.updateMethod(s1);
    }



    @DeleteMapping
    public String deleteMethod(){
        return hws.deleteMethod();
    }

    @DeleteMapping("/{std_id}")
    public String deleteMethodById(@PathVariable int std_id){
        return hws.deleteMethodById(std_id);
    }
}
