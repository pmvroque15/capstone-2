package com.pluralsight.collect;

import java.util.ArrayList;

public class Sandwich implements Product {
    private SandwichSize sandwichSize;
    private BreadType breadType;
    private double price;
    private boolean isToasted;
    private ArrayList<Ingredient> ingredients = new ArrayList<>();

    public Sandwich(SandwichSize sandwichSize, BreadType breadType, boolean isToasted) {
        this.sandwichSize = sandwichSize;
        this.breadType = breadType;
        this.price = sandwichSize.getPrice();
        this.isToasted = isToasted;
    }

    public SandwichSize getSize() {
        return sandwichSize;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public double getPrice() {
        return price;
    }



    @Override
    public double calculatePrice(){
        return 100;
    }
}
