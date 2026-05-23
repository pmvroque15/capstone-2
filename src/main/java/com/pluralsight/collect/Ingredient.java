package com.pluralsight.collect;

public abstract class Ingredient {
    private String name;
    private boolean isExtra;

    public Ingredient(String name, boolean isExtra) {
        this.name = name;
        this.isExtra = isExtra;
    }

    public String getName() {
        return name;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public abstract double getPrice(SandwichSize size);
}
