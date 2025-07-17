package com.example.Symptom_Advicer.service;

import com.example.Symptom_Advicer.model.Patient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PatientService {
    List<Patient> stu = new ArrayList<>(
            Arrays.asList( new Patient(1,"sathana",25,"Female","7612398456","15,rainbow colony chennai"),
                    new Patient(2,"ramya",28,"Female","9785346231","16,annasalai,trichy"))
    );

    public List<Patient> getMethod(){
        return stu;
    }

    public Patient getMethodById(int std_id){
        int ind=0;
        boolean flag=false;
        for(int i=0;i<stu.size();i++){

            if(std_id == stu.get(i).getId()){
                System.out.println("Patient Fetched : "+stu.get(i).getId()+stu.get(i));
                ind=i;
                flag=true;
                break;
            }

        }

        if(flag){
            return stu.get(ind);
        }
        else{
            return new Patient();
        }
    }


    public String postMethod(Patient s){
        stu.add(s);
        return "Patient Added Successfully!! "+s;
    }


    public String updateMethod(Patient s1) {
        int ind=0;
        boolean flag=false;
        for(int i=0;i<stu.size();i++){
            if(s1.getId()==stu.get(i).getId()){
                ind=i;
                flag=true;
            }
        }
        if(flag){
            stu.set(ind,s1);
            return "Patient Updated Successfully";
        }
        else{
            return "No such Patient Exist!!";
        }
    }


    public String deleteMethod(){
        return "This is a Delete Method";
    }

    public String deleteMethodById(int stdId) {
        int ind=0;
        boolean flag=false;
        for(int i=0;i<stu.size();i++){
            if(stdId==stu.get(i).getId()){
                ind=i;
                flag=true;
            }
        }
        if(flag){
            stu.remove(ind);
            return "Patient Deleted successfully!!!";
        }
        else{
            return "No Such Patient found!!! ";
        }
    }

}
