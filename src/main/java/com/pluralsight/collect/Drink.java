package com.pluralsight.collect;

import com.pluralsight.enums.DrinkSize;

public class Drink implements Product {
    private DrinkSize drinkSize;
    private double price = 0;
    private String flavour;
    public Drink(DrinkSize drinkSize, String flavour) {
        this.drinkSize = drinkSize;
        this.price = drinkSize.getPrice();
        this.flavour = flavour;
    }

    public String getFlavour() {
        return flavour;
    }

    public DrinkSize getDrinkSize() {
        return drinkSize;
    }

    @Override
    public double calculatePrice() {
        return this.price;
    }

    public String toString(){
        return String.format("Drink: %s Size: %s%n", getDrinkSize(), getFlavour());
    }
}
