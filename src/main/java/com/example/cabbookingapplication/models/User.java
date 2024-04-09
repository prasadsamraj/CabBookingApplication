package com.example.cabbookingapplication.models;

import com.example.cabbookingapplication.enums.Gender;
import com.example.cabbookingapplication.enums.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class User extends BaseModel{
    private String name;
    private String phoneNumber;
    private Gender gender;
    private int age;
    private UserType userType;

    public User(String name, String phoneNumber, Gender gender, int age, UserType userType) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
        this.userType = userType;
    }
}
