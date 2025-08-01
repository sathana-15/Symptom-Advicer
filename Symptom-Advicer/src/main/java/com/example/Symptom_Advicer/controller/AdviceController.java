package com.example.Symptom_Advicer.controller;

import com.example.Symptom_Advicer.model.Advice;
import com.example.Symptom_Advicer.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/advice")
public class AdviceController {

    @Autowired
    private AdviceService adviceService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_DOCTOR')")
    @PostMapping
    public Advice addAdvice(@RequestBody Advice advice) {
        return adviceService.addAdvice(advice);
    }

    @GetMapping("/{keyword}")
    public String getAdvice(@PathVariable String keyword) {
        Optional<Advice> advice = adviceService.getAdviceByKeyword(keyword);
        return advice.map(Advice::getAdviceText)
                .orElse("No advice found for: " + keyword);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_DOCTOR')")
    @GetMapping
    public List<Advice> getAllAdvice() {
        return adviceService.getAllAdvice();
    }

}
