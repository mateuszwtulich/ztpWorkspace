package com.company.pizza;

import java.math.BigDecimal;

public class PizzaZSzynka extends PizzaZDodatkami {

    private static final BigDecimal HAM_PRICE = new BigDecimal(7);
    private static final String NAME = "szynka";

    public PizzaZSzynka(Pizza basePizza) {
        super(basePizza, HAM_PRICE, NAME);
    }
}

