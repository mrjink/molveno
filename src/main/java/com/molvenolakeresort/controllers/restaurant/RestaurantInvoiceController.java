package com.molvenolakeresort.controllers.restaurant;

import com.molvenolakeresort.models.restaurant.order.RestaurantInvoice;
import com.molvenolakeresort.repositories.restaurant.order.RestaurantInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("api/restaurant/invoice")
public class RestaurantInvoiceController {

    @Autowired
    private final RestaurantInvoiceRepository repository;
//

    public RestaurantInvoiceController(RestaurantInvoiceRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    List<RestaurantInvoice> all() {
        return repository.findAll();
    }

    @PostMapping("/add")
    public RestaurantInvoice addRestaurantInvoice(@RequestBody RestaurantInvoice restaurantInvoice) {
        return repository.save(restaurantInvoice);
    }
    //
    @GetMapping("/get/{id}")
    public RestaurantInvoice getRestaurantInvoice(@PathVariable Long id) throws EntityNotFoundException {

        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }
    //
    @PutMapping("/update/{id}")
    public RestaurantInvoice updateRestaurantInvoice(@RequestBody RestaurantInvoice updatedRestaurantInvoice, @PathVariable Long id) {
        return repository.save(updatedRestaurantInvoice);
    }
    //
    @DeleteMapping("/delete/{id}")
    public void deleteRestaurantInvoice(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
