package com.pluralsight.collect;

import com.pluralsight.enums.BreadType;
import com.pluralsight.enums.SandwichSize;

import java.util.HashSet;

public class Sandwich implements Product {
    private SandwichSize sandwichSize;
    private BreadType breadType;
    private boolean isToasted;
    private HashSet<Ingredient> ingredients = new HashSet<>();

    public Sandwich(SandwichSize sandwichSize, BreadType breadType, boolean isToasted) {
        this.sandwichSize = sandwichSize;
        this.breadType = breadType;
        this.isToasted = isToasted;
    }

    public SandwichSize getSize() {
        return sandwichSize;
    }

    public BreadType getBreadType() {
        return breadType;
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

    public HashSet<Ingredient> getIngredients() {
        return ingredients;
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
