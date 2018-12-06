package com.molvenolakeresort.controllers.restaurant;

import com.molvenolakeresort.models.restaurant.menu.Menu;
import com.molvenolakeresort.repositories.restaurant.menu.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("api/restaurant/menu")
public class MenuController {

    @Autowired
    private final MenuRepository repository;
//

    public MenuController(MenuRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    List<Menu> all() {
        return repository.findAll();
    }

    @PostMapping("/add")
    public Menu addMenu(@RequestBody Menu menu) {
        return repository.save(menu);
    }
    //
    @GetMapping("/get/{id}")
    public Menu getMenu(@PathVariable Long id) throws EntityNotFoundException {

        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }
    //
    @PutMapping("/update/{id}")
    public Menu updateMenu(@RequestBody Menu updatedMenu, @PathVariable Long id) {
        return repository.save(updatedMenu);
    }
    //
    @DeleteMapping("/delete/{id}")
    public void deleteMenu(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
