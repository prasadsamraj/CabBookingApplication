package com.example.cabbookingapplication.dtos.requestdtos;

import com.example.cabbookingapplication.enums.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerRequestDto {
    private String name;
    private String phoneNumber;
    private Gender gender;
    private int age;
}
