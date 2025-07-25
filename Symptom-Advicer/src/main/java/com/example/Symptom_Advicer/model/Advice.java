package com.example.Symptom_Advicer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("advice") // table name in DB
public class Advice {

    @Id
    private Long id;

    private String symptomKeyword;
    private String adviceText;
    private String createdBy;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymptomKeyword() {
        return symptomKeyword;
    }

    public void setSymptomKeyword(String symptomKeyword) {
        this.symptomKeyword = symptomKeyword;
    }

    public String getAdviceText() {
        return adviceText;
    }

    public void setAdviceText(String adviceText) {
        this.adviceText = adviceText;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
