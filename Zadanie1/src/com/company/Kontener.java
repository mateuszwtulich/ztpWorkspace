package com.company;

import java.util.ArrayList;


public class Kontener<T extends Osoba>{

    private ArrayList<T> list = new ArrayList<T>();

    public Kontener(){
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

}
