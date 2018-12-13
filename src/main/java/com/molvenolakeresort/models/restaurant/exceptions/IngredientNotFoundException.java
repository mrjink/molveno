package com.molvenolakeresort.models.restaurant.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Ingredient not found")
public class IngredientNotFoundException extends IllegalArgumentException
{
    public IngredientNotFoundException(Long id) {
        super( String.format("Ingredient with %s not found",id));
    }
}
