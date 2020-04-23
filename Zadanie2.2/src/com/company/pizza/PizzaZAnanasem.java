package com.company.pizza;

import java.math.BigDecimal;

public class PizzaZAnanasem extends PizzaZDodatkami{
    private static final BigDecimal PINEAPPLE_PRICE = new BigDecimal(5);
    private static final String NAME = "ananasem";

    public PizzaZAnanasem(Pizza basePizza) {
        super(basePizza, PINEAPPLE_PRICE, NAME);
    }
}
