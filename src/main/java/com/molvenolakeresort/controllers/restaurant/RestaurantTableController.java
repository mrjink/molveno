package com.molvenolakeresort.controllers.restaurant;



import com.molvenolakeresort.models.restaurant.RestaurantTable;
import com.molvenolakeresort.repositories.restaurant.RestaurantTableRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/restaurant/restauranttable")
public class RestaurantTableController {

    private final RestaurantTableRepository repository;
    public RestaurantTableController(RestaurantTableRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    List<RestaurantTable> all() {
        return repository.findAll();
    }

    @PostMapping("/add")
    public RestaurantTable addTable(@RequestBody RestaurantTable restaurantTable) {
        return repository.save(restaurantTable);
    }
/*
    @GetMapping("/get/{id}")
    public RestaurantTable getTable(@PathVariable Long id) throws TableNotFoundException {

        return repository.findById(id).orElseThrow(() -> new TableNotFoundException(id));
    }*/
    //
    /*
    @PutMapping("/update/{id}")
    public RestaurantTable updateTable(@RequestBody RestaurantTable updatedReservation, @PathVariable Long id) {
        return repository.save(updatedReservation);
    }
    //
    @DeleteMapping("/delete/{id}")
    public void deleteTable(@PathVariable Long id) {
        repository.deleteById(id);
    }*/
}
