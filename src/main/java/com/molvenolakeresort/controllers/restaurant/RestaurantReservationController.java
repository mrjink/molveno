package com.molvenolakeresort.controllers.restaurant;

import com.molvenolakeresort.models.restaurant.RestaurantReservation;
import com.molvenolakeresort.models.restaurant.exceptions.ReservationNotFoundException;
import com.molvenolakeresort.repositories.restaurant.RestaurantReservationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/restaurant/reservation")
public class RestaurantReservationController {

    private final RestaurantReservationRepository repository;

    public RestaurantReservationController(RestaurantReservationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    List<RestaurantReservation> all() {
        return repository.findAll();
    }

    @PostMapping("/add")
    public RestaurantReservation addReservation(@RequestBody RestaurantReservation restaurantReservation) {
        return repository.save(restaurantReservation);
    }
//
    @GetMapping("/get/{id}")
    public RestaurantReservation getReservation(@PathVariable Long id) throws ReservationNotFoundException {

        return repository.findById(id).orElseThrow(() -> new ReservationNotFoundException(id));
    }
//
    @PutMapping("/update/{id}")
    public RestaurantReservation updateReservation(@RequestBody RestaurantReservation updatedRestaurantReservation, @PathVariable Long id) {
        return repository.save(updatedRestaurantReservation);
    }
//
    @DeleteMapping("/delete/{id}")
    public void deleteReservation(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
