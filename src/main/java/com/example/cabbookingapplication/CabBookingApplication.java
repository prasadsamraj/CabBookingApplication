package com.example.cabbookingapplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CabBookingApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CabBookingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
