package com.pluralsight.collect;

public class Side extends Sandwich {
    private final String name;

    public Side(String name) {
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
        return String.format("SIDE: %s%nPRICE: $%.2f", getName(), getPrice());
    }
}
