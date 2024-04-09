package com.example.cabbookingapplication.dtos.responsedtos;

import com.example.cabbookingapplication.enums.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponseDto {
    private Long bookingId;
    private String message;
    private ResponseStatus responseStatus;
}
