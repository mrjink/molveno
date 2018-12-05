package com.molvenolakeresort.controllers.restaurant;

import com.molvenolakeresort.models.restaurant.stock.Stock;
import com.molvenolakeresort.repositories.restaurant.stock.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("api/restaurant/stock")
public class StockController {

    @Autowired
    private final StockRepository repository;
//

    public StockController(StockRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    List<Stock> all() {
        return repository.findAll();
    }

    @PostMapping("/add")
    public Stock addStock(@RequestBody Stock Stock) {
        return repository.save(Stock);
    }
    //
    @GetMapping("/get/{id}")
    public Stock getStock(@PathVariable Long id) throws EntityNotFoundException {

        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }
    //
    @PutMapping("/update/{id}")
    public Stock updateStock(@RequestBody Stock updatedStock, @PathVariable Long id) {
        return repository.save(updatedStock);
    }
    //
    @DeleteMapping("/delete/{id}")
    public void deleteStock(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
