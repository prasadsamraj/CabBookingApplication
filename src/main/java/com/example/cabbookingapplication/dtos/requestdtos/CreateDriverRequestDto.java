package com.example.cabbookingapplication.dtos.requestdtos;

import com.example.cabbookingapplication.enums.Availability;
import com.example.cabbookingapplication.enums.Gender;
import com.example.cabbookingapplication.enums.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDriverRequestDto {
    private String name;
    private String phoneNumber;
    private Gender gender;
    private int age;
    private String vehicleRegNumber;
    private String vehicleMaker;
    private String vehicleModel;
    private VehicleType vehicleType;
    private int locationXVal;
    private int locationYVal;
    private Availability availability;
}
