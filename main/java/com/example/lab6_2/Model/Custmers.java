package com.example.lab6_2.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Custmers {
    @NotNull//id must be null
    @Pattern(regexp = "^10\\d{8}$") //id must start with 10 and eccept only 10 numbers.
    private Integer id;
    @NotNull//id must be null
    @Pattern(regexp = "^[a-zA-Z]+$")//must be only charactrs.
    @Size(min = 4)//you should entertd at least 4 charcters.
    private String name;
    @NotNull
    @Pattern(regexp = "^05\\d{8}$")//phone number must start with 05 and contin 10 Digits
    private String phoneNumber;
    @Email // the email must set on email form.
    private String Email;
    @Past()//must be on the past
    private LocalDate BirthDate;

}
