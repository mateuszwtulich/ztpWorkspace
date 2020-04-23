package com.company.pizza;

import java.math.BigDecimal;

public class PizzaZPapryka extends PizzaZDodatkami {
    private static final BigDecimal PEPPER_PRICE = new BigDecimal(5);
    private static final String NAME = "papryka";

    public PizzaZPapryka(Pizza basePizza) {
        super(basePizza, PEPPER_PRICE, NAME);
    }
}
