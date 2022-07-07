package pl.sda.arp4.spring_rental.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arp4.spring_rental.model.Car;
import pl.sda.arp4.spring_rental.repository.CarRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor

public class CarService {

    private final CarRepository carRepository;

    public List<Car> getAllCars() {
       return carRepository.findAll();
    }

    public void addCar(Car car) {
        carRepository.save(car);
    }

    public void deleteById(Long identyfikator) {
        carRepository.deleteById(identyfikator);
    }

    public void updateCar(Car samochodEdytowany) {

        Long identifier = samochodEdytowany.getId();

        Optional<Car> carOptional = carRepository.findById(identifier);
        if (carOptional.isPresent()) {
            Car carPoEdycji = carOptional.get();

            if (samochodEdytowany.getNazwa() != null) {
                carPoEdycji.setNazwa(samochodEdytowany.getNazwa());
            }
            if (samochodEdytowany.getDataProdukcji() != null) {
                carPoEdycji.setDataProdukcji(samochodEdytowany.getDataProdukcji());
            }
            if (samochodEdytowany.getNadwozie() != null) {
                carPoEdycji.setNadwozie(samochodEdytowany.getNadwozie());
            }
            if (samochodEdytowany.getIloscPasazerow() != null) {
                carPoEdycji.setIloscPasazerow(samochodEdytowany.getIloscPasazerow());
            }
            if (samochodEdytowany.getSkrzyniaBiegow() != null) {
                carPoEdycji.setSkrzyniaBiegow(samochodEdytowany.getSkrzyniaBiegow());
            }
            if (samochodEdytowany.getPojemnoscSilnika() != null) {
                carPoEdycji.setPojemnoscSilnika(samochodEdytowany.getPojemnoscSilnika());
            }
            carRepository.save(carPoEdycji);
            log.info("Samochód został zapisany.");
            return;
        }
        throw new EntityNotFoundException("Nie znaleziono samochodu o id: " + samochodEdytowany.getId());
    }

    }
