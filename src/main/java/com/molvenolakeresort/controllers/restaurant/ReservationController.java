package com.molvenolakeresort.controllers.restaurant;

import com.molvenolakeresort.models.kitchen.exceptions.ReservationNotFoundException;
import com.molvenolakeresort.models.kitchen.restaurant.Reservation;
import com.molvenolakeresort.models.kitchen.restaurant.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/restaurant/reservation")
public class ReservationController {

    @Autowired
    private final ReservationRepository repository;
//

    public ReservationController(ReservationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    List<Reservation> all() {
        return repository.findAll();
    }

    @PostMapping("/add")
    public Reservation addReservation(@RequestBody Reservation Reservation) {
        return repository.save(Reservation);
    }
//
    @GetMapping("/get/{id}")
    public Reservation getReservation(@PathVariable Long id) throws ReservationNotFoundException {

        return repository.findById(id).orElseThrow(() -> new ReservationNotFoundException(id));
    }
//
    @PutMapping("/update/{id}")
    public Reservation updateReservation(@RequestBody Reservation updatedReservation, @PathVariable Long id) {
        return repository.save(updatedReservation);
    }
//
    @DeleteMapping("/delete/{id}")
    public void deleteReservation(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
