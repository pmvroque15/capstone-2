package com.pluralsight.collect;

public class Sauce implements Product{
    private final String name;

    public Sauce(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public boolean isExtra() {
        return false;
    }

    @Override
    public double calculatePrice() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("SAUCE: %s%nPRICE: $%.2f%n", getName(), calculatePrice());
    }
}
