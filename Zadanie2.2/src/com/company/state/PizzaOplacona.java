package com.company.state;

import com.company.pizza.Pizza;

public class PizzaOplacona extends StatusPizzy {

    @Override
    public void goNext(Pizza pizza) throws InterruptedException {
        Thread.sleep(1000);
    }
}
