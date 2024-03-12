package com.example.lab6_2.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    @NotNull //must be not null
    @Size(min=5 , max = 10)//must be at least 5 charcters and max 10 charcters.
    private String UserName;
    @NotNull
    @Pattern(regexp = ("((?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*\\W)\\w.{6,18}\\w)")) //must be Upper cas and contins digtis and numbers and symbol.
    private String Pssword;
    @NotNull //must be not null
    @Size(min=7)//must  be 7 digits at least
    private int accountNumber;
    @NotNull
    @Positive //must be only postive numbers
    private double balance;

}
