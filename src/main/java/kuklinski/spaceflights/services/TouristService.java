package kuklinski.spaceflights.services;

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

    public void addTourist(Tourist tourist) {
        touristRepository.save(tourist);
    }

    public void removeTourist(Tourist tourist) {
        touristRepository.delete(tourist);
    }

    public void removeTouristFromFlight(Tourist tourist) {
        touristRepository.delete(tourist);
    }
}
