package com.example.cabbookingapplication.controllers;

import com.example.cabbookingapplication.dtos.requestdtos.CreateCustomerRequestDto;
import com.example.cabbookingapplication.dtos.responsedtos.CreateCustomerResponseDto;
import com.example.cabbookingapplication.enums.Gender;
import com.example.cabbookingapplication.enums.ResponseStatus;
import com.example.cabbookingapplication.exceptions.CustomerAlreadyRegisteredException;
import com.example.cabbookingapplication.models.Customer;
import com.example.cabbookingapplication.services.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {
    @Autowired
    CustomerController customerController;
    @MockBean
    CustomerService customerService;
    @Test
    public void createCustomerPositiveFlowTest() throws CustomerAlreadyRegisteredException {
        CreateCustomerRequestDto requestDto = new CreateCustomerRequestDto();
        requestDto.setName("Prasad");
        requestDto.setGender(Gender.MALE);
        requestDto.setAge(28);
        requestDto.setPhoneNumber("2222222");

        Customer customer = new Customer("Prasad", "2222222", Gender.MALE, 28);
        customer.setId(1L);
        when(customerService.createCustomer(
                requestDto.getName(),
                requestDto.getPhoneNumber(),
                requestDto.getGender(),
                requestDto.getAge()))
                .thenReturn(customer);
        CreateCustomerResponseDto responseDto = new CreateCustomerResponseDto();
        responseDto.setMessage("Customer created successfully.");
        responseDto.setId(1L);
        responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        Assertions.assertEquals(customerController.createCustomer(requestDto).getResponseStatus(), responseDto.getResponseStatus());
    }
}