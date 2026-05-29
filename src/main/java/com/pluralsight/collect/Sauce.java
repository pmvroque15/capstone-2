package com.pluralsight.collect;

public class Sauce extends Sandwich implements Product{

    public Sauce(String name) {
        super(name);
    }

    public String getName() {
        return super.getName();
    }

    public boolean isExtra() {
        return false;
    }

    @Override
    public double calculatePrice() {
        return 0;
    }
}
