package com.pluralsight.collect;

public class Sandwich implements Product {
    private SandwichSize sandwichSize;
    private BreadType breadType;
    private double price;
    private boolean isToasted;

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
    public double calculateTotal(){
        return 0;
    }
}
