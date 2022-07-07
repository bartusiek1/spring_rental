package pl.sda.arp4.spring_rental.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.arp4.spring_rental.model.Car;
import pl.sda.arp4.spring_rental.service.CarService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/car")
@RequiredArgsConstructor


public class CarController {

    private final CarService carService;

    // READ
    @GetMapping("/list")
    public List<Car> getAllCars() {
        log.info("Wywołano listę samochodów.");

        List<Car> list = carService.getAllCars();
        return list;
    }

    // CREATE
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCar(@RequestBody Car car) {
        log.info("Wywołano dodanie samochodu: " + car);

        carService.addCar(car);
    }

    // DELETE
    @DeleteMapping("/delete/{identifier}")
    public void deleteCar(@PathVariable(name = "identifier") Long identyfikator) {
        log.info("Wywołano usunięcie samochodu: " + identyfikator);

        carService.deleteById(identyfikator);
    }

    // UPDATE
    @PatchMapping("/update")
    public void updateCar(@RequestBody Car car) {
        log.info("Wywiołano aktualizację samochodu: " + car);

        carService.updateCar(car);
    }
}
