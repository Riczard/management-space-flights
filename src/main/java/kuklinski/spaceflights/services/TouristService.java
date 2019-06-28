package kuklinski.spaceflights.services;

import kuklinski.spaceflights.domain.Flight;
import kuklinski.spaceflights.domain.Tourist;
import kuklinski.spaceflights.repositories.FlightRepository;
import kuklinski.spaceflights.repositories.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private TouristRepository touristRepository;

    public List<Tourist> getTouristList() {
        return touristRepository.findAll();
    }

    public Tourist getTourist(long id) {
        return touristRepository.getOne(id);
    }

    public Tourist addTourist(Tourist tourist) {
        return touristRepository.save(tourist);
    }

    public void removeTourist(Tourist tourist) {
        touristRepository.delete(tourist);
    }

    public List<Tourist> removeTourist(long id) {
        touristRepository.deleteById(id);
        return getTouristList();
    }


    public void removeFlightFromTourist(Flight flight, long id) {
        Tourist tourist = getTourist(id);
        tourist.removeFlight(flight);
        touristRepository.save(tourist);
    }

    public void addFlightToTourist(Flight flight, long id) {
        Tourist tourist = getTourist(id);
        tourist.addFlight(flight);
        touristRepository.save(tourist);
    }
}
