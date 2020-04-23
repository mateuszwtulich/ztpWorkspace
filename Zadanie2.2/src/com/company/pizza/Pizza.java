package com.company.pizza;

import com.company.state.StatusPizzy;

import java.math.BigDecimal;

public class Pizza {
    private static final BigDecimal BASE_PRICE = new BigDecimal(12);
    private StatusPizzy current;

    public BigDecimal getPrice() {
        return BASE_PRICE;
    }

    public void setStatusPizzy(StatusPizzy state)
    {
        current = state;
        System.out.println("Status " + this.toString() + " ##### " + current.getClass());
    }

    public void Request() throws InterruptedException {
        current.goNext(this);
    }

    @Override
    public String toString() {
        return "Pizza podstawowa w cenie " + getPrice();
    }
}