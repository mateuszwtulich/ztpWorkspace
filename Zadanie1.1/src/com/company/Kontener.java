package com.company;

import java.util.ArrayList;


public class Kontener<T extends Osoba>{

    private ArrayList<T> list;

    public Kontener(){
        list = new ArrayList<T>();
    }

    public void add(T t){
        list.add((T) t);
    }

    public void addAll(ArrayList<T> list){
        list.forEach(t-> this.list.add(t));
    }

    public ArrayList<T> getAll() {
        return list;
    }

    public void pokazDane(){
        System.out.println("Wszystkie dane elementów z kontenera:");
        this.list.forEach( t -> System.out.println(t.toString()));
        System.out.println();
    }
}
