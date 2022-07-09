package pl.sda.arp4.spring_rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.arp4.spring_rental.model.CarRental;

public interface CarRentalRepository extends JpaRepository<CarRental, Long> {
}

