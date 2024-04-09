package com.example.cabbookingapplication.dtos.responsedtos;

import com.example.cabbookingapplication.enums.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDriverResponseDto {
    private Long id;
    private ResponseStatus responseStatus;
    private String message;
}
