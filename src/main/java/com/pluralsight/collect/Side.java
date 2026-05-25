package com.pluralsight.collect;

public class Side extends Sandwich {

    public Side(String name) {
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
