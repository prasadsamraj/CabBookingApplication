package com.example.cabbookingapplication.strategies;

import com.example.cabbookingapplication.models.Driver;
import com.example.cabbookingapplication.models.Location;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SearchVehicleStrategy {
    List<Driver> getNearByDrivers(Location source, List<Driver> allDrivers, int distance);
}
