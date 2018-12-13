package com.molvenolakeresort.tools;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;

public class JSONReader<T> {

    public T[] initObject(Class<T> type, String resourceNameOrPath) throws IOException, NullPointerException {
        Class<T> classOfT;
        T[] returnArray = (T[]) Array.newInstance(type, 0);

        ObjectMapper mapper = new ObjectMapper();
        returnArray = (T[]) mapper.readValue(ClassLoader.getSystemClassLoader().getResourceAsStream(resourceNameOrPath), returnArray.getClass());
        if (returnArray == null) {
            returnArray = (T[]) Array.newInstance(type, 0);
        }
        return returnArray;
    }
}
