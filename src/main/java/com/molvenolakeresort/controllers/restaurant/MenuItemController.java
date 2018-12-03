package com.molvenolakeresort.controllers.restaurant;

import com.molvenolakeresort.models.restaurant.menu.MenuItem;
import com.molvenolakeresort.repositories.restaurant.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("api/restaurant/menuitem")
public class MenuItemController {

    @Autowired
    private final MenuItemRepository repository;
//

    public MenuItemController(MenuItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    List<MenuItem> all() {
        return repository.findAll();
    }

    @PostMapping("/add")
    public MenuItem addMenuItem(@RequestBody MenuItem MenuItem) {
        return repository.save(MenuItem);
    }
    //
    @GetMapping("/get/{id}")
    public MenuItem getMenuItem(@PathVariable Long id) throws EntityNotFoundException {

        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }
    //
    @PutMapping("/update/{id}")
    public MenuItem updateMenuItem(@RequestBody MenuItem updatedMenuItem, @PathVariable Long id) {
        return repository.save(updatedMenuItem);
    }
    //
    @DeleteMapping("/delete/{id}")
    public void deleteMenuItem(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
