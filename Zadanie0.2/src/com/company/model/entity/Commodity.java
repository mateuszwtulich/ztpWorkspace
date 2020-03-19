package com.company.model.entity;

import java.io.Serializable;

import static java.lang.Math.random;

public class Commodity implements Serializable {

    private static long serialVersionUID = 1L;

    public Commodity(long id, String name, int amount, float value, float taxRate) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.value = value;
        this.taxRate = taxRate;
    }

    private long id;
    private String name;
    private int amount;
    private float value;
    private float taxRate;

    public Commodity(){
        id = (long) (Math.random()*10000);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(float taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public String toString() {
        return '\n' + "ID: " + Long.toString(id) + " " + name + " " + value + "x " + amount;
    }
}
