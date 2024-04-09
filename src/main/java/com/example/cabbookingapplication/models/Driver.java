package com.example.cabbookingapplication.models;

import com.example.cabbookingapplication.enums.Availability;
import com.example.cabbookingapplication.enums.Gender;
import com.example.cabbookingapplication.enums.UserType;
import com.example.cabbookingapplication.enums.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Driver extends User{
    private Vehicle vehicle;
    private Location location;
    private Availability availability;

    public Driver(String name, String phoneNumber, Gender gender, int age, Vehicle vehicle, Location location, Availability availability) {
        super(name, phoneNumber, gender, age, UserType.DRIVER);
        this.vehicle = vehicle;
        this.location = location;
        this.availability = availability;
    }

}
