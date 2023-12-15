package vttp.ssf.assessment.eventmanagement.models;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import vttp.ssf.assessment.eventmanagement.Util.Utils;

public class Participants {
    
    @Autowired
    Utils utils;

    @NotBlank(message = "Compulsory field") @Size(min = 5, max = 25,message = "Please fill in between 5-25 characters")
    private String fullname;

    @Past@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate DOB;

    // @Min(21)
    // private Integer Age;

    @Email@NotBlank@Size(max = 50)@NotBlank(message = "Compulsory field")
    private String email;

    @Pattern(regexp = "[89]\\d{7}$",message = "there must be a total of 8 numbers, starting with 8 or 9")
    private String phoneNo;
    
    private String gender;

    @Min(1)@Max(3)
    private int NumOfTicks;

    

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getNumOfTicks() {
        return NumOfTicks;
    }

    public void setNumOfTicks(int numOfTicks) {
        NumOfTicks = numOfTicks;
    }
    // @Bean("getAge")
    // public Integer getAge() {
    //     return Age;
    // }
    
    // public void setAge() {
    //     this.Age = utils.calculateAge(DOB);
    // }

    
    
}
