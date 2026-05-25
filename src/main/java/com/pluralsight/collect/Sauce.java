package com.pluralsight.collect;

public class Sauce extends Sandwich {

    public Sauce(String name) {
        //Always free and it comes with a sauce
        super(name, false);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String toString() {
        return String.format("Sauce: %s%n", getName());
    }
}
