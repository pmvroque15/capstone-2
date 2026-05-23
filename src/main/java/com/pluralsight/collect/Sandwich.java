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

    public boolean getIsToasted() {
        return isToasted;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
    }

    @Override
    public double calculatePrice() {
        double total = sandwichSize.getPrice();

        for (Ingredient ingredient : ingredients) {
            total += ingredient.getPrice(sandwichSize);

        }

        return total;
    }
}
