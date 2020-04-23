package com.company.pizza;

import java.math.BigDecimal;
import java.util.ArrayList;

public class PizzaZDodatkami extends Pizza {
    private final Pizza basePizza;
    private final BigDecimal toppingPrice;
    private static ArrayList<String> toppingNames = new ArrayList();

    public PizzaZDodatkami(Pizza pizza, BigDecimal toppingPrice, String name) {
        this.basePizza = pizza;
        this.toppingPrice = toppingPrice;
        toppingNames.add(name);
    }

    @Override
    public BigDecimal getPrice() {
        return basePizza.getPrice().add(toppingPrice);
    }

    public void clearList(){
        toppingNames.clear();
    }

    @Override
    public String toString() {
        String result = "Pizza z ";
        for ( String n: toppingNames) {
            result += n;
            result += ", ";
        }
        result += "w cenie: " + getPrice();
        return result;
    }
}
