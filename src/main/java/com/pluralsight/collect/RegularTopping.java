package com.pluralsight.collect;

public class RegularTopping extends Sandwich implements Product {
    private final String name;

    public RegularTopping(String name) {
        super(name);
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
}
