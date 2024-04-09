package com.example.cabbookingapplication.strategies;

import com.example.cabbookingapplication.models.Driver;
import com.example.cabbookingapplication.models.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class DistanceBasedPricingStrategy implements PricingStrategy{
    //all drivers are assigned with fixed price = 10* distance(source-dest) is assigned.
    @Override
    public List<Long> getPrices(List<Driver> nearByDrivers, Location source, Location dest) {
        int price = (int) (distance(source,dest)*10);
        return Stream.generate(()-> (long) price).limit(nearByDrivers.size()).toList();
    }
    //distance between source and dest is found.
    double distance(Location l1, Location l2){
        int x1 = l1.getX();
        int y1 = l1.getY();
        int x2 = l2.getX();
        int y2 = l2.getY();
        return Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
    }
}
