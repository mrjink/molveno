package com.molvenolakeresort.repositories.exceptions;

public class DuplicateEntryException extends Exception{

    public DuplicateEntryException(String message) {
        super(message);
    }

    public DuplicateEntryException(Class t)
    {
        super(String.format("%s already exists", t.getName()));
    }

    public DuplicateEntryException(Object obj)
    {
        super(String.format("%s already exists: %s", obj.getClass(), obj));
    }

}
