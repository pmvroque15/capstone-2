package com.pluralsight.collect;

import com.pluralsight.enums.DrinkSize;

public class Drink implements Product {
    private DrinkSize drinkSize;
    private double price = 0;

    public Drink(DrinkSize drinkSize) {
        this.drinkSize = drinkSize;
        this.price = drinkSize.getPrice();
    }

    @Override
    public double calculatePrice() {
        return this.price;
    }
}
