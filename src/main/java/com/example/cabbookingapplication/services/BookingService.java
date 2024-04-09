package com.example.cabbookingapplication.services;

import com.example.cabbookingapplication.exceptions.InvalidCustomerIdException;
import com.example.cabbookingapplication.exceptions.NoDriversAvailableException;
import com.example.cabbookingapplication.exceptions.RideNotAvailableException;
import com.example.cabbookingapplication.models.Booking;
import com.example.cabbookingapplication.models.Location;
import com.example.cabbookingapplication.models.Ride;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {

    List<Ride> findRide(Long customerId, Location source, Location dest, int distance) throws InvalidCustomerIdException, NoDriversAvailableException;

    Booking bookRide(Long customerId, Ride selectedRide, Location source, Location dest) throws InvalidCustomerIdException, RideNotAvailableException;
}
