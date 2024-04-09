package com.example.cabbookingapplication.dtos.requestdtos;

import com.example.cabbookingapplication.models.Location;
import com.example.cabbookingapplication.models.Ride;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequestDto {
    private Ride selectedRide;
    private Long customerId;
    private Location source;
    private Location dest;
}
