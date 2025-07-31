package com.example.Symptom_Advicer.service;

import com.example.Symptom_Advicer.model.Advice;
import com.example.Symptom_Advicer.repository.AdviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdviceService {

    @Autowired
    private AdviceRepository adviceRepository;



    public Advice addAdvice(Advice advice) {
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        advice.setCreatedBy(currentUser);
        return adviceRepository.save(advice);
    }


    public Optional<Advice> getAdviceByKeyword(String keyword) {
        return adviceRepository.findBySymptomKeywordIgnoreCase(keyword);
    }

    public List<Advice> getAllAdvice() {
        return adviceRepository.findAll();
    }

}
