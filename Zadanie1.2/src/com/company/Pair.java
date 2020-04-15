package com.company;

public class Pair<T> implements Cloneable{
    private T first;
    private T second;

    Pair(T first, T second){
        this.first = first;
        this.second = second;
    }

    public Pair<T> clone() throws CloneNotSupportedException {
        return (Pair<T>) super.clone();
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}
