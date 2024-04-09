package com.example.cabbookingapplication.dtos.responsedtos;

import com.example.cabbookingapplication.enums.ResponseStatus;
import com.example.cabbookingapplication.models.Ride;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class FindRideResponseDto {
    private List<Ride> nearestRides;
    private ResponseStatus responseStatus;
    private String message;
}
