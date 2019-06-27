package kuklinski.spaceflights.repositories;

import kuklinski.spaceflights.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {

Flight findById(long id);
}
