package com.molvenolakeresort.controllers.restaurant;

import com.molvenolakeresort.models.restaurant.enums.Unit;
import com.molvenolakeresort.models.restaurant.httpResponseModel.HttpErrorMessage;
import com.molvenolakeresort.models.restaurant.httpResponseModel.HttpResponse;
import com.molvenolakeresort.models.restaurant.stock.Ingredient;
import com.molvenolakeresort.models.restaurant.stock.IngredientMenuItem;
import com.molvenolakeresort.models.restaurant.stock.SupplyOrderSupplierIngredient;
import com.molvenolakeresort.repositories.restaurant.stock.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.molvenolakeresort.models.restaurant.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("api/restaurant/ingredient")
public class IngredientController {

    @Autowired
    private final IngredientRepository repository;

    public IngredientController(IngredientRepository repository) {
        this.repository = repository;
    }

    /**
     * <p>Get all ingredients</p>
     * <p>GET - Endpoint: api/restaurant/ingredient/all</p>
     * @return The list of all ingredients
     */
    @GetMapping("/all")
    Object all()
    {
        try{
            return repository.findAll();
        }catch (Exception e)
        {
            HttpResponse error_response = new HttpResponse("Error retrieving ingredients");
            return new ResponseEntity<>(error_response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public Ingredient addIngredient(@RequestBody Ingredient ingredient) {
        return repository.save(ingredient);
    }

    /**
     * Get the target ingredient based on the ID provided
     * <p>GET - Endpoint: api/restaurant/ingredient/get/{id}</p>
     * @param id The target ingredient ID
     * @return The target ingredient(s) with {@link HttpStatus#OK} or {@link ResponseEntity} with {@link HttpStatus#NOT_FOUND} contain the error message
     */
    @GetMapping("/get/{id}")
    public Object getIngredient(@PathVariable Long id)
    {
        try{
            Optional<Ingredient> target_ingredient = repository.findById(id);

            if (target_ingredient.isPresent())
                return target_ingredient;
            else
                throw new EntityNotFoundException();

        }catch (EntityNotFoundException e)
        {
            HttpResponse error_response = new HttpResponse("Ingredient not found");
            return new ResponseEntity<>(error_response, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * <p>Update an ingredient properties based on the ID provided</p>
     * <p>PUT - Endpoint: api/restaurant/ingredient/delete/{id}</p>
     * @param updatedIngredient The updated ingredient properties
     * @param id The target ingredient ID
     * @return
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateIngredient(@RequestBody IngredientDTO updatedIngredient, @PathVariable Long id) {

        HttpResponse error_response = new HttpResponse("Temporary unavailable");
        return new ResponseEntity<>(error_response, HttpStatus.SERVICE_UNAVAILABLE);

        //TODO: temporary disabled due to issue with database
//        if (!isValidUnit(updatedIngredient.getUnit()))
//        {
//            HttpResponse error = new HttpResponse("Invalid argument");
//            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//        }
//
//        try{
//
//            Optional<Ingredient> target_ingredient = repository.findById(id);
//
//            if (!target_ingredient.isPresent())
//            {
//                HttpResponse error_response = new HttpResponse("Item does not exist");
//                return new ResponseEntity<>(error_response, HttpStatus.NOT_FOUND);
//            }
//
//            Ingredient ingredient = target_ingredient.get();
//
//            ingredient.setName(updatedIngredient.getName() == null ? ingredient.getName() : updatedIngredient.getName());
//            ingredient.setNotes(updatedIngredient.getNotes() == null ? ingredient.getNotes() : updatedIngredient.getNotes());
//            ingredient.setUnit(updatedIngredient.getUnit() == null ? convertToUnit(updatedIngredient.getUnit()) : ingredient.getUnit());
//            ingredient.setIngredientMenuItems( updatedIngredient.getIngredientMenuItems() == null ? ingredient.getIngredientMenuItems() : updatedIngredient.getIngredientMenuItems());
//            ingredient.setSupplierIngredients( updatedIngredient.getSupplierIngredients() == null ? ingredient.getSupplierIngredients() : updatedIngredient.getSupplierIngredients());
//            ingredient.setSupplyOrderSupplierIngredients(updatedIngredient.getSupplyOrderSupplierIngredients() == null ? ingredient.getSupplyOrderSupplierIngredients() : updatedIngredient.getSupplyOrderSupplierIngredients());
//
//            if (repository.save(ingredient) != null)
//            {
//                HttpResponse response = new HttpResponse("ingredient updated");
//                return new ResponseEntity<>(response, HttpStatus.OK);
//            }else{
//                HttpResponse error_response = new HttpResponse("Failed updating ingredient");
//                return new ResponseEntity<>(error_response, HttpStatus.NOT_FOUND);
//            }
//        }catch (Exception e)
//        {
//            System.out.println("Error: "+e.getMessage());
//            HttpResponse error_response = new HttpResponse("Error updating ingredient");
//            return new ResponseEntity<>(error_response, HttpStatus.NOT_FOUND);
//        }

    }

    /**
     * <p>Delete an ingredient based on the ID provided</p>
     * <p>GET - Endpoint: api/restaurant/ingredient/delete/{id}</p>
     * @param id The ingredient ID
     * @return Response indicating that the deletion task succeed with {@link HttpStatus#OK} or an error message with {@link HttpStatus#NOT_FOUND} in case it failed
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteIngredient(@PathVariable Long id)
    {
        if(id == null)
        {
            HttpErrorMessage error = new HttpErrorMessage("Missing argument");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

        try{
            repository.deleteById(id);
            HttpResponse response = new HttpResponse("ingredient deleted");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e)
        {

            HttpErrorMessage error = new HttpErrorMessage("Ingredient not found");
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }


    private boolean isValidUnit(String unit)
    {
        for (Unit valid_unit : Unit.values())
        {
            if (unit.equals(valid_unit.toString()))
                return true;
        }

        return false;
    }

    private Unit convertToUnit(String raw_unit_value)
    {
        if (raw_unit_value == null)
            return Unit.PIECES;

        for (Unit unit : Unit.values())
        {
            if (raw_unit_value.equals(unit.toString()))
                return unit;
        }

        return Unit.PIECES;
    }
}
