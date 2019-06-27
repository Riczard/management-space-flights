package kuklinski.spaceflights.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String gender;

    @Column
    private String country;

    @Column
    private String remarks;

    @Column
    private Date dateOfBirth;

    @OneToMany(mappedBy = "flight")
    @ElementCollection
    private List<Flight> listOfFlights;
}
