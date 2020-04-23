package com.company.pizza;

import java.math.BigDecimal;

public class PizzaZPomidorem extends PizzaZDodatkami{
    private static final BigDecimal TOMATO_PRICE = new BigDecimal(3);
    private static final String NAME = "pomidorem";

    public PizzaZPomidorem(Pizza basePizza) {
        super(basePizza, TOMATO_PRICE, NAME);
    }
}
