package com.pluralsight.collect;

public class Sauce extends Sandwich {
    private final String name;

    public Sauce(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return 0;
    }
    @Override
    public String toString() {
        return String.format("SAUCE: %s%nPRICE: $%.2f%n", getName(), getPrice());
    }
}
