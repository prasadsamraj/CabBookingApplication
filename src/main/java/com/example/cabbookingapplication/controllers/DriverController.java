package com.example.cabbookingapplication.controllers;

import com.example.cabbookingapplication.dtos.requestdtos.CreateDriverRequestDto;
import com.example.cabbookingapplication.dtos.responsedtos.CreateDriverResponseDto;
import com.example.cabbookingapplication.enums.ResponseStatus;
import com.example.cabbookingapplication.exceptions.DriverAlreadyRegisteredException;
import com.example.cabbookingapplication.models.Driver;
import com.example.cabbookingapplication.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DriverController {
    private final DriverService driverService;
    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }
//Creates driver in the system, uses phone number as unique identifier.
    public CreateDriverResponseDto createDriver(CreateDriverRequestDto requestDto){
        CreateDriverResponseDto responseDto = new CreateDriverResponseDto();
        try {
            Driver driver = driverService.createDriver(
                    requestDto.getName(),
                    requestDto.getPhoneNumber(),
                    requestDto.getAge(),
                    requestDto.getGender(),
                    requestDto.getVehicleRegNumber(),
                    requestDto.getVehicleMaker(),
                    requestDto.getVehicleModel(),
                    requestDto.getVehicleType(),
                    requestDto.getLocationXVal(),
                    requestDto.getLocationYVal(),
                    requestDto.getAvailability()
            );
            responseDto.setId(driver.getId());
        } catch (DriverAlreadyRegisteredException exception) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            responseDto.setMessage(exception.getMessage());
            return responseDto;
        }
        responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        responseDto.setMessage("Driver created successfully.");
        return responseDto;
    }
}
