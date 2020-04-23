package com.company.state;

import com.company.pizza.Pizza;

public class PizzaDostarczona extends StatusPizzy{

    @Override
    public void goNext(Pizza pizza) throws InterruptedException {
        Thread.sleep(2000);
        pizza.setStatusPizzy(new PizzaOplacona());
    }
}
