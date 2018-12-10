package com.molvenolakeresort.controllers.restaurant;

import com.molvenolakeresort.models.restaurant.stock.Stock;
import com.molvenolakeresort.models.restaurant.stock.dto.StockDTO;
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
    public Stock addStock(@RequestBody Stock stock) {
        return repository.save(stock);
    }
    //
    @GetMapping("/get/{id}")
    public Stock getStock(@PathVariable Long id) throws EntityNotFoundException {

        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }
    //
    @PutMapping("/update/{id}")
    public Stock updateStock(@RequestBody Stock stock, @PathVariable Long id) {

        return repository.save(stock);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStock(@PathVariable Long id) {
        repository.deleteById(id);
    }

    /**
     * Create a {@link Stock} object from a {@link StockDTO}
     * @param stockDTO The stock dto object
     * @return The converted {@link Stock} object
     */
    private Stock createStockObject(StockDTO stockDTO)
    {
        Stock stockObject = new Stock();
        stockObject.setQuantity(stockDTO.getQuantity());

        return stockObject;
    }
}
