package com.example.cabbookingapplication.services;

import com.example.cabbookingapplication.enums.Availability;
import com.example.cabbookingapplication.enums.BookingStatus;
import com.example.cabbookingapplication.exceptions.InvalidCustomerIdException;
import com.example.cabbookingapplication.exceptions.NoDriversAvailableException;
import com.example.cabbookingapplication.exceptions.RideNotAvailableException;
import com.example.cabbookingapplication.models.*;
import com.example.cabbookingapplication.strategies.PricingStrategy;
import com.example.cabbookingapplication.strategies.SearchVehicleStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class InMemoryBookingService implements BookingService{
    private final PricingStrategy pricingStrategy;
    private final SearchVehicleStrategy searchVehicleStrategy;
    private final CustomerService customerService;
    private final DriverService driverService;
    private final HashMap<Long, Booking> bookingHashMap = new HashMap<>();
    private long counter = 0;
    @Autowired
    public InMemoryBookingService(PricingStrategy pricingStrategy, SearchVehicleStrategy searchVehicleStrategy, CustomerService customerService, DriverService driverService) {
        this.pricingStrategy = pricingStrategy;
        this.searchVehicleStrategy = searchVehicleStrategy;
        this.customerService = customerService;
        this.driverService = driverService;
    }

    public List<Ride> findRide(Long customerId, Location source, Location dest, int distance) throws InvalidCustomerIdException, NoDriversAvailableException {
        customerService.findById(customerId);
        //checks if there is any nearby drivers available and list of the same is returned.
        List<Driver> nearByDrivers = searchVehicleStrategy.getNearByDrivers(source, driverService.getAllDrivers(), 5);
        //if no drivers available, throw exception.
        if(nearByDrivers.isEmpty()) throw new NoDriversAvailableException();
        //get the pricing of different drivers. As of now all drivers will have same price of 10 per unit distance.
        List<Long> prices = pricingStrategy.getPrices(nearByDrivers, source, dest);
        //ride is basically combination of driver and their pricing and its returned as list.
        List<Ride> nearByRides = new ArrayList<>();
        for(int i=0; i<nearByDrivers.size(); i++){
            nearByRides.add(new Ride(nearByDrivers.get(i), prices.get(i)));
        }
        return nearByRides;
    }
//after finding ride, the same is passed to below booking method and the booking is confirmed.
    @Override
    public synchronized Booking bookRide(Long customerId, Ride selectedRide, Location source, Location dest) throws InvalidCustomerIdException, RideNotAvailableException {
        if(!selectedRide.getDriver().getAvailability().equals(Availability.AVAILABLE)) throw new RideNotAvailableException();
        Booking booking = new Booking();
        booking.setCustomer(customerService.findById(customerId));
        booking.setSource(source);
        booking.setDest(dest);
        booking.setPrice(selectedRide.getPrice());
        booking.setDriver(selectedRide.getDriver());

        //updating driver status and booking status to booked.
        selectedRide.getDriver().setAvailability(Availability.BOOKED);
        booking.setBookingStatus(BookingStatus.BOOKED);

        //adding the booking to hashmap for in memory retrieval.
        counter++;
        bookingHashMap.put(counter, booking);
        booking.setId(counter);
        return booking;
    }
}
