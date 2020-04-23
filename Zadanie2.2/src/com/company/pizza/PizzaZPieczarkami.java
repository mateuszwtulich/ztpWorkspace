package com.company.pizza;

import java.math.BigDecimal;

public class PizzaZPieczarkami extends PizzaZDodatkami {
    private static final BigDecimal MUSHROOM_PRICE = new BigDecimal(5);
    private static final String NAME = "pieczarkami";

    public PizzaZPieczarkami(Pizza basePizza) {
        super(basePizza, MUSHROOM_PRICE, NAME);
    }
}