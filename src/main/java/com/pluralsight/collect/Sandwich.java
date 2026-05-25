package com.pluralsight.collect;

import java.util.HashSet;
import java.util.Objects;

public abstract class Sandwich implements Product {
    private SandwichSize sandwichSize;
    private BreadType breadType;
    private final HashSet<Sandwich> ingredients = new HashSet<>();
    private boolean isToasted;

    public Sandwich() {

    }

    public Sandwich(SandwichSize sandwichSize, BreadType breadType, boolean isToasted) {
        this.sandwichSize = sandwichSize;
        this.breadType = breadType;
        this.isToasted = isToasted;
    }

    public Sandwich(SandwichSize sandwichSize) {
        this.sandwichSize = sandwichSize;
    }

    public SandwichSize getSize() {
        return sandwichSize;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public void addIngredient(Sandwich ingredient) {
        ingredients.add(ingredient);
    }

    public void removeIngredient(Sandwich ingredient) {
        ingredients.remove(ingredient);
    }

    public HashSet<Sandwich> getIngredients() {
        return ingredients;
    }

    //Abstract method/s
    abstract double getPrice();

    @Override
    public double calculatePrice() {
        double total = sandwichSize.getPrice();

        for (Sandwich s : ingredients) {
            total += s.getPrice();

        }

        return total;
    }

//    Using StringBuilder to append customizations of the sandwich for order summary.
//    Thought of just looping through the ingredients Hashset but every loop, it creates a brand new object vs. StringBuilder
//    it just builds one whole bigString object in memory. Saves time and memory
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  ").append(this.sandwichSize).append(" on ").append(this.breadType);

        //if it's not toasted, just leave it empty and move forward.
        if (isToasted) {
            sb.append(" (Toasted)");
        }

        sb.append("\n");

        //looping through hashset of ingredients and appending it to the sb object.
        for (Sandwich ingredient : ingredients) {
            if(ingredient == null) {
                sb.append(" ");
            }
            //if extra ingredient, then append extra after the ingredient
            if (ingredient.isExtra()) {
                sb.append("           ").append(" - ")
                        .append(ingredient.getName())
                        .append(" (extra)\n");
            } else {
                sb.append("           ").append(" - ")
                        .append(ingredient.getName())
                        .append("\n");
            }


        }
        sb.append("--------------------------------------");

        //returns to the toString of sb object!
        return sb.toString();
    }




}
