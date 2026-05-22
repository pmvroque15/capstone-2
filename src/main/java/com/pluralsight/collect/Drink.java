package com.pluralsight.collect;

public class Drink implements Product {
    private DrinkSize drinkSize;
    private double price = 0;

    public Drink(DrinkSize drinkSize, double price) {
        this.drinkSize = drinkSize;
        this.price = drinkSize.getPrice();
    }

    @Override
    public double calculateTotal() {
        return 0;
    }
}
