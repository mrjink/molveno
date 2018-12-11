package com.molvenolakeresort.controllers.restaurant;

import com.molvenolakeresort.models.restaurant.stock.Ingredient;
import com.molvenolakeresort.repositories.restaurant.stock.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
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

//    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "ingredient_not_found")
    public ResponseEntity<String> deleteIngredient(@PathVariable Long id) {
        try{
            repository.deleteById(id);
            return ResponseEntity.ok("id deleted");
        }catch (IllegalArgumentException e)
        {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            return ResponseEntity.ok("not found");
        }
    }
}
