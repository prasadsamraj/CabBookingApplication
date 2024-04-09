package com.example.cabbookingapplication.services;

import com.example.cabbookingapplication.enums.Gender;
import com.example.cabbookingapplication.exceptions.CustomerAlreadyRegisteredException;
import com.example.cabbookingapplication.exceptions.InvalidCustomerIdException;
import com.example.cabbookingapplication.models.Customer;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class InMemoryCustomerService implements CustomerService{
    private static final HashMap<Long, Customer> customerHashMap = new HashMap<>();
    private static long counter = 0;
    //customer is created and added to hashmap
    //if phone number is not unique them exception is thrown
    public Customer createCustomer(String name, String phoneNumber, Gender gender, int age) throws CustomerAlreadyRegisteredException {
        for(Long id: customerHashMap.keySet()){
            if(customerHashMap.get(id).getPhoneNumber().equals(phoneNumber)){
                throw new CustomerAlreadyRegisteredException();
            }
        }
        counter++;
        Customer customer = new Customer(name, phoneNumber, gender, age);
        customer.setId(counter);
        customerHashMap.put(counter, customer);
        return customer;
    }
    //Based on id, customer object is retrieved from the hashmap.
    public Customer findById(Long id) throws InvalidCustomerIdException {
        if(customerHashMap.containsKey(id))
            return customerHashMap.get(id);
        else
            throw new InvalidCustomerIdException();
    }
}
