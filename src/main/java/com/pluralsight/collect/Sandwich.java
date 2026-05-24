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

    //Using StringBuilder to append customizations of the sandwich for order summary.
    //Thought of just looping through the ingredients Hashset but every loop, it creates a brand new object vs. StringBuilder
    //it just builds one whole bigString object in memory. Saves time and memory
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(sandwichSize).append(" on ").append(breadType);

        //if it's not toasted, just leave it empty and move forward.
        if (!isToasted) {
            sb.append("");
        }

        sb.append(" (Toasted)");
        sb.append("\n");

        //looping through hashset of ingredients and appending it to the sb object.
        for (Ingredient ingredient : ingredients) {
            //if extra ingredient, then append extra after the ingredient
            if (ingredient.isExtra()) {
                sb.append(" - ").append(ingredient.getName()).append(" (extra)\n");
            }

            sb.append(" - ").append(ingredient.getName()).append("\n");

        }
        sb.append(String.format("%nSubtotal: $%.2f", calculatePrice()));
        //returns to the toString of sb object!
        return sb.toString();
    }
}
