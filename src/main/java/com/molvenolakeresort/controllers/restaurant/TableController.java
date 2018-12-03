package com.molvenolakeresort.controllers.restaurant;



import com.molvenolakeresort.models.restaurant.Table;
import com.molvenolakeresort.models.restaurant.enums.TableShape;
import com.molvenolakeresort.repositories.restaurant.TableRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/restaurant/table")
public class TableController {

    private final TableRepository repository;
    public TableController(TableRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    List<Table> all() {
        return repository.findAll();
    }

    @PostMapping("/add")
    public Table addTable(@RequestBody Table table) {
        return repository.save(table);
    }
/*
    @GetMapping("/get/{id}")
    public Table getTable(@PathVariable Long id) throws TableNotFoundException {

        return repository.findById(id).orElseThrow(() -> new TableNotFoundException(id));
    }*/
    //
    /*
    @PutMapping("/update/{id}")
    public Table updateTable(@RequestBody Table updatedReservation, @PathVariable Long id) {
        return repository.save(updatedReservation);
    }
    //
    @DeleteMapping("/delete/{id}")
    public void deleteTable(@PathVariable Long id) {
        repository.deleteById(id);
    }*/
}
