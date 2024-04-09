package com.example.cabbookingapplication.strategies;

import com.example.cabbookingapplication.enums.Availability;
import com.example.cabbookingapplication.models.Driver;
import com.example.cabbookingapplication.models.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DistanceBasedSearchVehicleStrategy implements SearchVehicleStrategy{
    //This method gives the list of nearest drivers based on the distance provided in ascending order.
    @Override
    public List<Driver> getNearByDrivers(Location source, List<Driver> allDrivers, int distance) {
        List<Driver> nearByDrivers = new ArrayList<>();
        for(Driver driver:allDrivers){
            //driver is checked for availability.
            if(driver.getAvailability().equals(Availability.AVAILABLE)) {
                Location driverLocation = driver.getLocation();
                double driverDistance = distance(driverLocation, source);
                if (driverDistance <= distance)
                    nearByDrivers.add(driver);
            }
        }
        nearByDrivers.sort((Driver d1, Driver d2) -> {
            double diff = distance(d1.getLocation(), source)-distance(d2.getLocation(),source);
            if(diff>0) return 1;
            return -1;
        });
        return nearByDrivers;
    }
    //distance between two points is calculated
    double distance(Location l1, Location l2){
        int x1 = l1.getX();
        int y1 = l1.getY();
        int x2 = l2.getX();
        int y2 = l2.getY();
        return Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
    }
}
