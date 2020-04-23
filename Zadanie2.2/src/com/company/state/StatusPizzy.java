package com.company.state;

import com.company.pizza.Pizza;

public abstract class StatusPizzy {

    public abstract void goNext(Pizza pizza) throws InterruptedException;
}
