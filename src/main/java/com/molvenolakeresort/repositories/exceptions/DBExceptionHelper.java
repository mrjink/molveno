package com.molvenolakeresort.repositories.exceptions;

import org.springframework.dao.DataIntegrityViolationException;

import java.sql.SQLException;

public class DBExceptionHelper {

    private DBExceptionHelper() {}

    public static String parseMessage(Exception baseException, String warningIfParsed)
    {
        String message = baseException.getMessage();
        if(baseException instanceof DataIntegrityViolationException)
        {
            DataIntegrityViolationException dive = (DataIntegrityViolationException) baseException;
            Throwable subException = dive.getCause();
            while (subException.getCause() != null)
            {
                subException = subException.getCause();
            }
            if(subException instanceof SQLException)
            {
                SQLException sqlException = (SQLException) subException;
                if(sqlException.getSQLState().equals("23505"))
                {
                    message = String.format("%s already exists.", warningIfParsed);
                }
            }
        }
        return message;
    }
}
