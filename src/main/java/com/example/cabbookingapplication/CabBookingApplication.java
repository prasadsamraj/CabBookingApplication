package com.example.cabbookingapplication;

import com.example.cabbookingapplication.controllers.BookingController;
import com.example.cabbookingapplication.controllers.CustomerController;
import com.example.cabbookingapplication.controllers.DriverController;
import com.example.cabbookingapplication.dtos.requestdtos.BookingRequestDto;
import com.example.cabbookingapplication.dtos.requestdtos.CreateCustomerRequestDto;
import com.example.cabbookingapplication.dtos.requestdtos.CreateDriverRequestDto;
import com.example.cabbookingapplication.dtos.requestdtos.FindRideRequestDto;
import com.example.cabbookingapplication.dtos.responsedtos.CreateCustomerResponseDto;
import com.example.cabbookingapplication.dtos.responsedtos.CreateDriverResponseDto;
import com.example.cabbookingapplication.dtos.responsedtos.FindRideResponseDto;
import com.example.cabbookingapplication.enums.Availability;
import com.example.cabbookingapplication.enums.Gender;
import com.example.cabbookingapplication.enums.ResponseStatus;
import com.example.cabbookingapplication.enums.VehicleType;
import com.example.cabbookingapplication.models.Driver;
import com.example.cabbookingapplication.models.Location;
import com.example.cabbookingapplication.models.Ride;
import com.example.cabbookingapplication.models.User;
import com.example.cabbookingapplication.services.InMemoryDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class CabBookingApplication implements CommandLineRunner {
    @Autowired
    CustomerController customerController;
    @Autowired
    DriverController driverController;
    @Autowired
    BookingController bookingController;
    @Autowired
    InMemoryDriverService inMemoryDriverService;
    public static void main(String[] args) {
        SpringApplication.run(CabBookingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Creating three Customers to test user creation

        //1. Prasad
        CreateCustomerRequestDto requestDto1 = new CreateCustomerRequestDto();
        requestDto1.setName("Prasad");
        requestDto1.setAge(28);
        requestDto1.setPhoneNumber("1234567890");
        requestDto1.setGender(Gender.MALE);
        CreateCustomerResponseDto responseDto1 = customerController.createCustomer(requestDto1);
        System.out.println(responseDto1.getResponseStatus());
        System.out.println(responseDto1.getMessage());
        System.out.println(responseDto1.getId()+ " is created successfully");
        System.out.println();

        //2. Rakesh
        CreateCustomerRequestDto requestDto2 = new CreateCustomerRequestDto();
        requestDto2.setName("Rakesh");
        requestDto2.setAge(25);
        requestDto2.setPhoneNumber("1122334455");
        requestDto2.setGender(Gender.MALE);
        CreateCustomerResponseDto responseDto2 = customerController.createCustomer(requestDto2);
        System.out.println(responseDto2.getResponseStatus());
        System.out.println(responseDto2.getMessage());
        System.out.println(responseDto2.getId()+ " is created successfully");
        System.out.println();

        //3. John
        CreateCustomerRequestDto requestDto3 = new CreateCustomerRequestDto();
        requestDto3.setName("John");
        requestDto3.setAge(29);
        requestDto3.setPhoneNumber("1155448877");
        requestDto3.setGender(Gender.MALE);
        CreateCustomerResponseDto responseDto3 = customerController.createCustomer(requestDto3);
        System.out.println(responseDto3.getResponseStatus());
        System.out.println(responseDto3.getMessage());
        System.out.println(responseDto3.getId()+ " is created successfully");
        System.out.println();

        //Creating 3 drivers to run test
        //1.Lokesh
        CreateDriverRequestDto driverRequestDto1 = new CreateDriverRequestDto();
        driverRequestDto1.setName("Lokesh");
        driverRequestDto1.setAvailability(Availability.AVAILABLE);
        driverRequestDto1.setVehicleType(VehicleType.HATCHBACK);
        driverRequestDto1.setAge(20);
        driverRequestDto1.setLocationXVal(3);
        driverRequestDto1.setLocationYVal(0);
        driverRequestDto1.setGender(Gender.MALE);
        driverRequestDto1.setVehicleModel("Swift");
        driverRequestDto1.setVehicleMaker("Maruthi");
        driverRequestDto1.setPhoneNumber("852682459");
        driverRequestDto1.setVehicleRegNumber("KA17 AY 4545");
        CreateDriverResponseDto driverResponseDto1= driverController.createDriver(driverRequestDto1);
        System.out.println(driverResponseDto1.getResponseStatus());
        System.out.println(driverResponseDto1.getId());
        System.out.println(driverResponseDto1.getMessage());

        //2. Balu
        CreateDriverRequestDto driverRequestDto2 = new CreateDriverRequestDto();
        driverRequestDto2.setName("Balu");
        driverRequestDto2.setAvailability(Availability.AVAILABLE);
        driverRequestDto2.setVehicleType(VehicleType.SEDAN);
        driverRequestDto2.setAge(25);
        driverRequestDto2.setLocationXVal(3);
        driverRequestDto2.setLocationYVal(6);
        driverRequestDto2.setGender(Gender.MALE);
        driverRequestDto2.setVehicleModel("Ciaz");
        driverRequestDto2.setVehicleMaker("Maruthi");
        driverRequestDto2.setPhoneNumber("5588123456");
        driverRequestDto2.setVehicleRegNumber("TN74 AY 4545");
        CreateDriverResponseDto driverResponseDto2= driverController.createDriver(driverRequestDto2);
        System.out.println(driverResponseDto2.getResponseStatus());
        System.out.println(driverResponseDto2.getId());
        System.out.println(driverResponseDto2.getMessage());

        //3. Chandu
        CreateDriverRequestDto driverRequestDto3 = new CreateDriverRequestDto();
        driverRequestDto3.setName("Chandu");
        driverRequestDto3.setAvailability(Availability.AVAILABLE);
        driverRequestDto3.setVehicleType(VehicleType.SUV);
        driverRequestDto3.setAge(24);
        driverRequestDto3.setLocationXVal(3);
        driverRequestDto3.setLocationYVal(2);
        driverRequestDto3.setGender(Gender.MALE);
        driverRequestDto3.setVehicleModel("HARRIER");
        driverRequestDto3.setVehicleMaker("TATA");
        driverRequestDto3.setPhoneNumber("1541522222");
        driverRequestDto3.setVehicleRegNumber("KA 74 AY 1111");
        CreateDriverResponseDto driverResponseDto3= driverController.createDriver(driverRequestDto3);
        System.out.println(driverResponseDto3.getResponseStatus());
        System.out.println(driverResponseDto3.getId());
        System.out.println(driverResponseDto3.getMessage());

        //Finding rides
        //1. Able to find nearest rides
        FindRideRequestDto findRideRequestDto1 = new FindRideRequestDto();
        findRideRequestDto1.setCustomerId(1L);
        findRideRequestDto1.setDest(new Location(0,0));
        findRideRequestDto1.setSource(new Location(1,1));
        findRideRequestDto1.setDistance(6);
        FindRideResponseDto findRideResponseDto1 = bookingController.findRide(findRideRequestDto1);
        System.out.println(findRideResponseDto1.getResponseStatus());
        List<Ride> rides = findRideResponseDto1.getNearestRides();
        int i=1;
        System.out.println("Available Rides:");
        for(Ride ride:rides) {
            System.out.println(i++ + " " + ride.getDriver().getName() + " " + ride.getDriver().getVehicle().getMaker() + " " + ride.getDriver().getVehicle().getModel());
        }

        //Booking the nearest ride in above scenario
        BookingRequestDto bookingRequestDto = new BookingRequestDto();
        bookingRequestDto.setCustomerId(1L);
        bookingRequestDto.setSource(findRideRequestDto1.getSource());
        bookingRequestDto.setDest(findRideRequestDto1.getDest());
        bookingRequestDto.setSelectedRide(findRideResponseDto1.getNearestRides().get(0));
        bookingController.bookRide(bookingRequestDto);

        //2. No available rides within specified distance scenario
        FindRideRequestDto findRideRequestDto2 = new FindRideRequestDto();
        findRideRequestDto2.setCustomerId(2L);
        findRideRequestDto2.setDest(new Location(10,10));
        findRideRequestDto2.setSource(new Location(20,20));
        findRideRequestDto2.setDistance(6);
        FindRideResponseDto findRideResponseDto2 = bookingController.findRide(findRideRequestDto2);
        System.out.println(findRideResponseDto2.getResponseStatus());
        if(findRideResponseDto2.getNearestRides()==null){
            System.out.println("No rides available");
        }


        //3. Trying scenario 1 with drivers status set to not available.
        List<Driver> drivers = inMemoryDriverService.getAllDrivers();
        for(Driver driver:drivers){
            driver.setAvailability(Availability.NOT_AVAILABLE);
        }
        FindRideRequestDto findRideRequestDto3 = new FindRideRequestDto();
        findRideRequestDto3.setCustomerId(1L);
        findRideRequestDto3.setDest(new Location(0,0));
        findRideRequestDto3.setSource(new Location(1,1));
        findRideRequestDto3.setDistance(100);
        FindRideResponseDto findRideResponseDto3 = bookingController.findRide(findRideRequestDto3);
        System.out.println(findRideResponseDto3.getResponseStatus());
        if(findRideResponseDto3.getNearestRides()==null){
            System.out.println("No rides available");
        }

    }
}
