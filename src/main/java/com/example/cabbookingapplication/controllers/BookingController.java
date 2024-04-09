package com.example.cabbookingapplication.controllers;

import com.example.cabbookingapplication.dtos.requestdtos.BookingRequestDto;
import com.example.cabbookingapplication.dtos.responsedtos.BookingResponseDto;
import com.example.cabbookingapplication.dtos.requestdtos.FindRideRequestDto;
import com.example.cabbookingapplication.dtos.responsedtos.FindRideResponseDto;
import com.example.cabbookingapplication.enums.ResponseStatus;
import com.example.cabbookingapplication.exceptions.InvalidCustomerIdException;
import com.example.cabbookingapplication.exceptions.NoDriversAvailableException;
import com.example.cabbookingapplication.exceptions.RideNotAvailableException;
import com.example.cabbookingapplication.models.Booking;
import com.example.cabbookingapplication.models.Ride;
import com.example.cabbookingapplication.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookingController {
    private final BookingService bookingService;
    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    //this method returns the nearest rides based on the source and driver's distance.
    public FindRideResponseDto findRide(FindRideRequestDto requestDto){
        FindRideResponseDto responseDto = new FindRideResponseDto();
        try {
            List<Ride> rides = bookingService.findRide(
                    requestDto.getCustomerId(),
                    requestDto.getSource(),
                    requestDto.getDest(),
                    requestDto.getDistance()
            );
            responseDto.setNearestRides(rides);
        } catch (InvalidCustomerIdException | NoDriversAvailableException exception) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            responseDto.setMessage(exception.getMessage());
            return responseDto;
        }
        responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        responseDto.setMessage("Nearest rides found successfully.");
        return responseDto;
    }
    //this method confirms the booking for the user when a ride is selected.
    public BookingResponseDto bookRide(BookingRequestDto requestDto){
        BookingResponseDto responseDto = new BookingResponseDto();
        try {
            Booking booking = bookingService.bookRide(
                    requestDto.getCustomerId(),
                    requestDto.getSelectedRide(),
                    requestDto.getSource(),
                    requestDto.getDest()
            );
            responseDto.setBookingId(booking.getId());
        } catch (InvalidCustomerIdException | RideNotAvailableException exception) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            responseDto.setMessage(exception.getMessage());
        }
        responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        responseDto.setMessage("Booking is successful.");
        return responseDto;
    }
}
