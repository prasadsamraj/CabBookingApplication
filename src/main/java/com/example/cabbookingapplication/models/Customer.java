package com.example.cabbookingapplication.models;

import com.example.cabbookingapplication.enums.Gender;
import com.example.cabbookingapplication.enums.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer extends User{

    public Customer(String name, String phoneNumber, Gender gender, int age) {
        super(name, phoneNumber, gender, age, UserType.CUSTOMER);
    }
}
