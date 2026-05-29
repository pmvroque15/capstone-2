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

}
