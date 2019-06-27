package kuklinski.spaceflights.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private DateTimeFormatter departureDate;

    @Column
    private DateTimeFormatter arrivalDate;

    @Column
    private int numberOfSeats;

    @OneToMany
    private List<Tourist> listOfTourist;

    @Column
    private double price;

    public void addTourist(Tourist tourist) {
        listOfTourist.add(tourist);
    }

    public void removeTourist(Tourist tourist) {
        listOfTourist.remove(tourist);
    }
}
