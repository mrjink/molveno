package com.molvenolakeresort.controllers.restaurant;

import com.molvenolakeresort.models.restaurant.stock.Supplier;
import com.molvenolakeresort.repositories.restaurant.stock.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("api/restaurant/supplier")
public class SupplierController {

    @Autowired
    private final SupplierRepository repository;
//

    public SupplierController(SupplierRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    List<Supplier> all() {
        return repository.findAll();
    }

    @PostMapping("/add")
    public Supplier addSupplier(@RequestBody Supplier supplier) {
        return repository.save(supplier);
    }
    //
    @GetMapping("/get/{id}")
    public Supplier getSupplier(@PathVariable Long id) throws EntityNotFoundException {

        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }
    //
    @PutMapping("/update/{id}")
    public Supplier updateSupplier(@RequestBody Supplier updatedSupplier, @PathVariable Long id) {
        return repository.save(updatedSupplier);
    }
    //
    @DeleteMapping("/delete/{id}")
    public void deleteSupplier(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
