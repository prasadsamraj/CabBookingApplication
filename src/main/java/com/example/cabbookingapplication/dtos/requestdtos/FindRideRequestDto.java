package com.example.cabbookingapplication.dtos.requestdtos;

import com.example.cabbookingapplication.models.Location;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindRideRequestDto {
    private Long customerId;
    private Location source;
    private Location dest;
    private int distance;
}
