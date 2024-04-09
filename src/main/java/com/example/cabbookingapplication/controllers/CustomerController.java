package com.example.cabbookingapplication.controllers;

import com.example.cabbookingapplication.dtos.requestdtos.CreateCustomerRequestDto;
import com.example.cabbookingapplication.dtos.responsedtos.CreateCustomerResponseDto;
import com.example.cabbookingapplication.enums.ResponseStatus;
import com.example.cabbookingapplication.exceptions.CustomerAlreadyRegisteredException;
import com.example.cabbookingapplication.models.Customer;
import com.example.cabbookingapplication.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
//Method to create customer, uses phone number to identify unique customers.
    public CreateCustomerResponseDto createCustomer(CreateCustomerRequestDto requestDto){
        CreateCustomerResponseDto responseDto = new CreateCustomerResponseDto();
        try {
            Customer customer = customerService.createCustomer(
                    requestDto.getName(),
                    requestDto.getPhoneNumber(),
                    requestDto.getGender(),
                    requestDto.getAge()
            );
            responseDto.setId(customer.getId());
        } catch (CustomerAlreadyRegisteredException exception) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            responseDto.setMessage(exception.getMessage());
            return responseDto;
        }
        responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        responseDto.setMessage("Customer created successfully.");
        return responseDto;
    }
}
