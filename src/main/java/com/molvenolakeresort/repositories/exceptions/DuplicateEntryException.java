package com.molvenolakeresort.repositories.exceptions;

import com.fasterxml.jackson.databind.ObjectMapper;

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

    private DuplicateEntryException() {
    }


    private DuplicateEntryException(String message, Throwable cause) {
        super(message, cause);
    }

    private DuplicateEntryException(Throwable cause) {
        super(cause);
    }

    private DuplicateEntryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
