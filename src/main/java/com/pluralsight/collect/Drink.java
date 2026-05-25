package com.pluralsight.collect;

import com.pluralsight.enums.DrinkSize;

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

    public String toString(){
        return String.format("\t   %s $%.2f %n", getDrinkSize(), calculatePrice());
    }
}
