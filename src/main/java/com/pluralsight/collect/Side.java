package com.pluralsight.collect;

public class Side implements Product {
    private final String name;
    public Side(String name) {
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
        return String.format("  - %-35s %5.2f%n", getName(), calculatePrice());
    }

}
