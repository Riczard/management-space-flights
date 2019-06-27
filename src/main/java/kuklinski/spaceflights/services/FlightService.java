package kuklinski.spaceflights.services;

import kuklinski.spaceflights.domain.Flight;
import kuklinski.spaceflights.domain.Tourist;
import kuklinski.spaceflights.repositories.FlightRepository;
import kuklinski.spaceflights.repositories.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private TouristRepository touristRepository;

    public List<Flight> getFlightsList() {
        return flightRepository.findAll();
    }

    public Flight getFlight(long id) {
        return flightRepository.findById(id);
    }

    public void addFlight(Flight flight) {
        flightRepository.save(flight);
    }

    public void removeFlight(Flight flight) {
        flightRepository.delete(flight);
    }

    public void addTouristToFlight(Tourist tourist, long id) {
        Flight flight = getFlight(id);
        flight.addTourist(tourist);
        flightRepository.save(flight);
    }

    public void removeTouristFromFlight(Tourist tourist, long id) {
        Flight flight = getFlight(id);
        flight.removeTourist(tourist);
        flightRepository.save(flight);
    }
}
