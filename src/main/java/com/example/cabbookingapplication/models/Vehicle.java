package com.example.cabbookingapplication.models;

import com.example.cabbookingapplication.enums.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle extends BaseModel{
    private String regNumber;
    private String maker;
    private String model;
    private VehicleType vehicleType;
}
