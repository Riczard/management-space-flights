package kuklinski.spaceflights.controller;

import kuklinski.spaceflights.domain.Flight;
import kuklinski.spaceflights.domain.Tourist;
import kuklinski.spaceflights.services.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TouristController {

    @Autowired
    private TouristService touristService;

    @GetMapping("/tourist")
    public ResponseEntity<List<Tourist>> getAllTourists() {
        return new ResponseEntity<>(touristService.getTouristList(), HttpStatus.OK);
    }

    @GetMapping("/tourist/{id}")
    public ResponseEntity<Tourist> getTourist(@PathVariable long id) {
        return new ResponseEntity<>(touristService.getTourist(id), HttpStatus.OK);
    }

    @PostMapping("/tourist")
    public ResponseEntity<Tourist> addTourist(@Valid @RequestBody Tourist tourist) {
        return new ResponseEntity<>(touristService.addTourist(tourist), HttpStatus.CREATED);
    }

    @DeleteMapping("/tourist/{id}")
    public ResponseEntity<List<Tourist>> removeTourist(@PathVariable long id) {
        return new ResponseEntity<>(touristService.removeTourist(id), HttpStatus.OK);
    }

    @PostMapping("/tourist/{id}")
    public void removeFlight(@Valid @RequestBody Flight flight, @PathVariable("id") long id) {
        touristService.removeFlightFromTourist(flight, id);
    }

    @PostMapping("/tourist/{id}/flight")
    public void addFlightToTourist(@Valid @RequestBody Flight flight, @PathVariable("id") long id) {
        touristService.addFlightToTourist(flight, id);
    }
}
