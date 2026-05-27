package com.pluralsight.collect;

public class Drink implements Product {
    DrinkSize drinkSize;
    private final double price;
    public Drink(DrinkSize drinkSize) {
        this.drinkSize = drinkSize;
        this.price = drinkSize.getPrice();
    }

    public DrinkSize getDrinkSize() {
        return drinkSize;
    }

    @Override
    public double calculatePrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return "DRINK";
    }

    @Override
    public boolean isExtra() {
        return false;
    }

    public String toString(){
        return String.format("%s %-33s %.2f", getDrinkSize(), getName(), calculatePrice());
    }
}
