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

}
