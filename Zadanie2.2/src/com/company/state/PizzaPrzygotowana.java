package com.company.state;

import com.company.pizza.Pizza;

public class PizzaPrzygotowana extends StatusPizzy {

    @Override
    public void goNext(Pizza pizza) throws InterruptedException {
        Thread.sleep(4000);
        pizza.setStatusPizzy(new PizzaDostarczona());
    }
}
