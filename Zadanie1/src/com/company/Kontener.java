package com.company;

public class Kontener<T extends Osoba> {

    private T t;

    public Kontener(T t){
        this.t = t;
    }

    public T getT() {
        return t;
    }

    @Override
    public String toString() {
        return t.toString();
    }
}
