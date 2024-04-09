package com.example.cabbookingapplication.models;

import com.example.cabbookingapplication.enums.BookingStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Booking extends BaseModel{
    private Customer customer;
    private Driver driver;
    private BookingStatus bookingStatus;
    private Long price;
    private Location source;
    private Location dest;
}
