package com.company.state;

import com.company.pizza.Pizza;

public class PizzaZamowiona extends StatusPizzy {

    @Override
    public void goNext(Pizza pizza) throws InterruptedException {
        Thread.sleep(1000);
        pizza.setStatusPizzy(new PizzaPrzygotowana());
    }
}
