package com.molvenolakeresort.controllers.restaurant;

import com.molvenolakeresort.models.restaurant.order.Order;
import com.molvenolakeresort.repositories.restaurant.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("api/restaurant/order")
public class OrderController {

    @Autowired
    private final OrderRepository repository;
//

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    List<Order> all() {
        return repository.findAll();
    }

    @PostMapping("/add")
    public Order addOrder(@RequestBody Order order) {
        return repository.save(order);
    }
    //
    @GetMapping("/get/{id}")
    public Order getOrder(@PathVariable Long id) throws EntityNotFoundException {

        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }
    //
    @PutMapping("/update/{id}")
    public Order updateOrder(@RequestBody Order updatedOrder, @PathVariable Long id) {
        return repository.save(updatedOrder);
    }
    //
    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
