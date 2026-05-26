package com.pluralsight.collect;

import java.util.HashSet;

public class Sandwich implements Product {
    private final SandwichSize sandwichSize;
    private final BreadType breadType;
    private final HashSet<Product> ingredients = new HashSet<>();
    private final boolean isToasted;

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

    public void addIngredient(Product ingredient) {
        ingredients.add(ingredient);
    }

    public void removeIngredient(Product ingredient) {
        ingredients.remove(ingredient);
    }

    public HashSet<Product> getIngredients() {
        return ingredients;
    }

    @Override
    public String getName() {
        return "Sandwich";
    }

    @Override
    public boolean isExtra() {
        return false;
    }

    @Override
    public double calculatePrice() {
        double total = sandwichSize.getPrice();

        for (Product p : ingredients) {
            total += p.calculatePrice();
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
        for (Product p : ingredients) {

            if (p == null) {
                continue;
            }

            String name = p.getName();

            if(name == null || name.isBlank()) {
                continue;
            }

            sb.append("           -")
                    .append(name);
            //if extra ingredient, then append extra after the ingredient
            if (p.isExtra()) {
                sb.append(" (extra)");
            }
            sb.append("\n");

            if(p instanceof Drink drink) {
                sb.append(drink).append("\n");
            }

            if(p instanceof Chips chips) {
                sb.append(chips).append("\n");

            }
        }
        sb.append("--------------------------------------");

        //returns to the toString of sb object!
        return sb.toString();
    }

}
