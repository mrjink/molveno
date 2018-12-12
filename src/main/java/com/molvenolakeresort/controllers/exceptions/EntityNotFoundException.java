package com.molvenolakeresort.controllers.exceptions;

public class EntityNotFoundException extends Exception{

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(Class t, Object searchMethod)
    {
        super(String.format("Entity does not exist in %s db using [object of %s] with param(s) [%s]", t.getName(), searchMethod.getClass(), searchMethod.toString()));
    }
}
