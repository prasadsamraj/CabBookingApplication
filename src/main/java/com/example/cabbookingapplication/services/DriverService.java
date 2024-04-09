package com.example.cabbookingapplication.services;

import com.example.cabbookingapplication.enums.Availability;
import com.example.cabbookingapplication.enums.Gender;
import com.example.cabbookingapplication.enums.VehicleType;
import com.example.cabbookingapplication.exceptions.DriverAlreadyRegisteredException;
import com.example.cabbookingapplication.models.Driver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DriverService {

    Driver createDriver(String name, String phoneNumber, int age, Gender gender, String vehicleRegNumber, String vehicleMaker, String vehicleModel, VehicleType vehicleType, int locationXVal, int locationYVal, Availability availability) throws DriverAlreadyRegisteredException;
    List<Driver> getAllDrivers();
}
