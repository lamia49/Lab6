package com.example.lab6.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Employee {
    @NotNull
    @Size(min=2,message = "id length must be more than 2 characters")
    private String id;
    @NotNull
    @Size(min = 4,message ="name length must be more than 4 characters.")
    @Pattern(regexp = "^[a-zA-Z]+$",message ="name must contain only characters")
    private String name;
    @Email
    private String email;
//    @Pattern(regexp = "^05\\d{8}$",message = "phone number must start with 05 and consists of exactly 10 digits. ")
    private Integer phoneNumber;
    @NotNull
    @Min(value = 26,message = "must be more then 25")
    private Integer age;
    @NotNull
    @Pattern(regexp ="^(supervisor|coordinator)$",message = "Must be suprviser or coordinator")
    private String postion;
    private boolean onLeave; //it automatically initially  false.
//    @NotNull
   @PastOrPresent
    private LocalDate hireDate;
    @NotNull
    @Positive(message = "annual leave must be postive")
    private Integer annualLeave;





}
