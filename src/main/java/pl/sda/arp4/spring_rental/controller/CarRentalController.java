package pl.sda.arp4.spring_rental.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.sda.arp4.spring_rental.model.Car;
import pl.sda.arp4.spring_rental.model.CarRental;
import pl.sda.arp4.spring_rental.model.dto.CarDTO;
import pl.sda.arp4.spring_rental.model.dto.RentCarRequest;
import pl.sda.arp4.spring_rental.service.CarRentalService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/rental")
@RequiredArgsConstructor

public class CarRentalController {

    private final CarRentalService carRentalService;


    @GetMapping("/available")
    public List<CarDTO> getAvailableCars() {
        log.info("Requested rental available cars");
        return carRentalService.getAllAvailableCars();
    }

    @PostMapping("/rent")
    public void rentCar(@RequestParam Long carId, @RequestBody RentCarRequest request) {
        log.info("Requested rental of car with id: " + carId);
        carRentalService.rentCar(carId, request);
    }

    @PatchMapping("/return")
    public void returnCar(@RequestParam Long carId) {
        log.info("Requested return of car with id: " + carId);
        carRentalService.returnCar(carId);
    }

//    @PostMapping("/rent/{carId}")
//    public void rentCar(@PathVariable Long carId, @RequestBody CarRental carRental) {
//        log.info("Requested rental of car with id: " + carId);
//        carRentalService.rentCar(carId, carRental);
//    }
//    ###
//    POST http://localhost:18085/api/rental/rent/3
//    Content-Type: application/json
//
//    {
//        "clientName": "Pawel",
//            "clientSurname": "Gawel",
//            "price": 300.0
//    }
}
