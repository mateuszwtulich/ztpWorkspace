package com.company;

import java.lang.reflect.Array;

public class GenericArray<T> {
    private T[] array;

    GenericArray(Class<T[]> clazz, int length){
        array = clazz.cast(Array.newInstance(clazz.getComponentType(), length));
    }

    public T[] getArray() {
        return array;
    }
}
