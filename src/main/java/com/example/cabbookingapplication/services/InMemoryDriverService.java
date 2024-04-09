package com.example.cabbookingapplication.services;

import com.example.cabbookingapplication.enums.Availability;
import com.example.cabbookingapplication.enums.Gender;
import com.example.cabbookingapplication.enums.VehicleType;
import com.example.cabbookingapplication.exceptions.DriverAlreadyRegisteredException;
import com.example.cabbookingapplication.models.Driver;
import com.example.cabbookingapplication.models.Location;
import com.example.cabbookingapplication.models.Vehicle;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class InMemoryDriverService implements DriverService{
    private static final HashMap<Long, Driver> driverHashMap = new HashMap<>();
    private static long counter = 0;
    //Driver is created with personal, vehicle and location details and added to hashmap.
    @Override
    public Driver createDriver(String name, String phoneNumber, int age, Gender gender, String vehicleRegNumber, String vehicleMaker, String vehicleModel, VehicleType vehicleType, int locationXVal, int locationYVal, Availability availability) throws DriverAlreadyRegisteredException {
        for(Long id: driverHashMap.keySet()){
            if(driverHashMap.get(id).getPhoneNumber().equals(phoneNumber)){
                throw new DriverAlreadyRegisteredException();
            }
        }
        counter++;
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType(vehicleType);
        vehicle.setMaker(vehicleMaker);
        vehicle.setModel(vehicleModel);
        vehicle.setRegNumber(vehicleRegNumber);
        Location location = new Location();
        location.setX(locationXVal);
        location.setY(locationYVal);
        Driver driver = new Driver(name, phoneNumber, gender, age, vehicle,location,availability);
        driver.setId(counter);
        driverHashMap.put(counter, driver);
        return driver;
    }
    //method returns all drivers in the hashmap.
    @Override
    public List<Driver> getAllDrivers() {
        return driverHashMap.values().stream().toList();
    }
}
