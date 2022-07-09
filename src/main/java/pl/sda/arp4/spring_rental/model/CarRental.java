package pl.sda.arp4.spring_rental.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class CarRental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    ///
    private String clientName;
    private String clientSurname;
    @CreationTimestamp
    private LocalDateTime rentDateTime;
    private LocalDateTime returnDateTime;
    private Double price;
    @ManyToOne()
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference          // szybka moetoda na to, by po wynajęciu auta Json się nie zapętlał
    // i działała metoda -> lista wszytskich aut
    // Rozwiązanie skrótowe, niekompletne, bo działa w jedną stronę
    // (tu z Car do CarRentals)
    // Poza tym to mało bezpieczne, bo przesyłamy całą bazę danych i relacje między nimi
    // co jest łatwe dla hakerów do rozszyfrowania
    private Car car;

    public CarRental(String clientName, String clientSurname, Double price) {
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.price = price;
    }
}













