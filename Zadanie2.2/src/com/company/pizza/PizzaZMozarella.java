package com.company.pizza;

import java.math.BigDecimal;

public class PizzaZMozarella extends PizzaZDodatkami {

    private static final BigDecimal MOZZARELLA_PRICE = new BigDecimal(5);
    private static final String NAME = "mozarella";

    public PizzaZMozarella(Pizza basePizza) {
        super(basePizza, MOZZARELLA_PRICE, NAME);
    }
}
