package com.pluralsight.collect;

public class Drink implements Product {
    private final DrinkSize drinkSize;
    private double price = 0;
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
        return String.format("\t   %s %s $%.2f %n", getDrinkSize(), getName(), calculatePrice());
    }
}
