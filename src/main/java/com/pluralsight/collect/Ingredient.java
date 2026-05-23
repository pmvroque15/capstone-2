package com.pluralsight.collect;

public abstract class Ingredient {
    private String name;
    private boolean isExtra;

    public Ingredient(String name, boolean isExtra) {
        this.name = name;
        this.isExtra = isExtra;
    }

    abstract double getPrice();
}
