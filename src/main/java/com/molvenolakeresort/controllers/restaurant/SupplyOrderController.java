package com.molvenolakeresort.controllers.restaurant;

import com.molvenolakeresort.models.restaurant.stock.SupplyOrder;
import com.molvenolakeresort.repositories.restaurant.stock.SupplyOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("api/restaurant/supplyorder")
public class SupplyOrderController {

    @Autowired
    private final SupplyOrderRepository repository;
//

    public SupplyOrderController(SupplyOrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    List<SupplyOrder> all() {
        return repository.findAll();
    }

    @PostMapping("/add")
    public SupplyOrder addSupplyOrder(@RequestBody SupplyOrder SupplyOrder) {
        return repository.save(SupplyOrder);
    }
    //
    @GetMapping("/get/{id}")
    public SupplyOrder getSupplyOrder(@PathVariable Long id) throws EntityNotFoundException {

        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }
    //
    @PutMapping("/update/{id}")
    public SupplyOrder updateSupplyOrder(@RequestBody SupplyOrder updatedSupplyOrder, @PathVariable Long id) {
        return repository.save(updatedSupplyOrder);
    }
    //
    @DeleteMapping("/delete/{id}")
    public void deleteSupplyOrder(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
