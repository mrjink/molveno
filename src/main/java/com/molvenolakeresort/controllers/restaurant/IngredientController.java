package com.molvenolakeresort.controllers.restaurant;

import com.molvenolakeresort.models.restaurant.stock.Ingredient;
import com.molvenolakeresort.repositories.restaurant.stock.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("api/restaurant/ingredient")
public class IngredientController {

    @Autowired
    private final IngredientRepository repository;

    public IngredientController(IngredientRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    List<Ingredient> all() {
        return repository.findAll();
    }

    @PostMapping("/add")
    public Ingredient addIngredient(@RequestBody Ingredient ingredient) {
        return repository.save(ingredient);
    }
    //
    @GetMapping("/get/{id}")
    public Ingredient getIngredient(@PathVariable Long id) throws EntityNotFoundException {

        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }
    //
    @PutMapping("/update/{id}")
    public Ingredient updateIngredient(@RequestBody Ingredient updatedIngredient, @PathVariable Long id) {
        return repository.save(updatedIngredient);
    }
    //
    @DeleteMapping("/delete/{id}")
    public void deleteIngredient(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
