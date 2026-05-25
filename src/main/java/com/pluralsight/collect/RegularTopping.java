package com.pluralsight.collect;

import java.util.Objects;

public class RegularTopping extends Sandwich {
    private final String name;

    public RegularTopping(String name) {
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
        return String.format("Regular Topping: %s%nPRICE: $%.2f%n", getName(), getPrice());
    }

}
