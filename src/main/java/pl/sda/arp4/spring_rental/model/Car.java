package pl.sda.arp4.spring_rental.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String nazwa;
    private String marka;
    private LocalDate dataProdukcji;

    @Enumerated(EnumType.STRING)
    private TypNadwozia nadwozie;
    private Integer iloscPasazerow;

    @Enumerated(EnumType.STRING)
    private TypSkrzyni skrzyniaBiegow;
    private Double pojemnoscSilnika;

}
