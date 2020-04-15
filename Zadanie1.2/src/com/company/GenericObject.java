package com.company;

import java.lang.reflect.InvocationTargetException;

public class GenericObject<T> {
    private T object;

    public GenericObject(Class<T> tClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        object = tClass.getDeclaredConstructor().newInstance();
//        object = tClass.getDeclaredConstructor(int.class).newInstance(10);

    }

    public T getObject() {
        return object;
    }
}
