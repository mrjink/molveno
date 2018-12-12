package com.molvenolakeresort.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;

public class JSONReader<T> {

    public T[] initObject(Class<T> type, String resourceNameOrPath) throws IOException, NullPointerException {
        T[] returnArray = (T[]) Array.newInstance(type, 0);

        ClassLoader classLoader = getClass().getClassLoader();

        InputStream x = classLoader.getResourceAsStream(resourceNameOrPath);
        returnArray = (T[]) new ObjectMapper().readValue(x, returnArray.getClass());
        if (returnArray == null) {
            returnArray = (T[]) Array.newInstance(type, 0);
        }
        return returnArray;
    }
}
