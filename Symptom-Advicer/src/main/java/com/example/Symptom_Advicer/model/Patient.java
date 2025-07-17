package com.example.Symptom_Advicer.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data

public class Patient {
    private int id;
    private String fullName;
    private int age;
    private String gender;
    private String phone;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Patient(int id, String fullName, int age, String gender, String phone, String address) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }
}
