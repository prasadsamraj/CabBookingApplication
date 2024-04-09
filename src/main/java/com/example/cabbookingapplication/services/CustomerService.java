package com.example.cabbookingapplication.services;

import com.example.cabbookingapplication.enums.Gender;
import com.example.cabbookingapplication.exceptions.CustomerAlreadyRegisteredException;
import com.example.cabbookingapplication.exceptions.InvalidCustomerIdException;
import com.example.cabbookingapplication.models.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    Customer createCustomer(String name, String phoneNumber, Gender gender, int age) throws CustomerAlreadyRegisteredException;
    Customer findById(Long Id) throws InvalidCustomerIdException;
}
