package kuklinski.spaceflights.controller;

import kuklinski.spaceflights.domain.Flight;
import kuklinski.spaceflights.domain.Tourist;
import kuklinski.spaceflights.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import javax.validation.Valid;
import java.util.List;

@RestController
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/flight")
    public ResponseEntity<List<Flight>> getAllFlights() {
        return new ResponseEntity<>(flightService.getFlightsList(), HttpStatus.OK);
    }

    @GetMapping("/flight/{id}")
    public ResponseEntity<Flight> getFlight(@PathVariable long id) {
        return new ResponseEntity<>(flightService.getFlight(id), HttpStatus.OK);
    }

    @PostMapping("/flight")
    public ResponseEntity<Flight> addFlight(@Valid @RequestBody Flight flight) {
        return new ResponseEntity<>(flightService.addFlight(flight), HttpStatus.CREATED);
    }

    @DeleteMapping("/flight/{id}")
    public ResponseEntity<List<Flight>> removeFlight(@PathVariable long id) {
        return new ResponseEntity<>(flightService.removeFlightByID(id), HttpStatus.OK);
    }

    @PostMapping("flight/{id}")
    public void removeTouristFromFlight(@Valid @RequestBody Tourist tourist, @PathVariable("id") long id) {
        flightService.removeTouristFromFlight(tourist, id);
    }

    @PostMapping("flight/{id}/tourist")
    public void addTouristToFlight(@Valid @RequestBody Tourist tourist, @PathVariable("id") long id){
        flightService.addTouristToFlight(tourist, id);
    }
}
