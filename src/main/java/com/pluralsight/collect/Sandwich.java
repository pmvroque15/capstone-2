package com.pluralsight.collect;

import java.util.HashSet;
import java.util.Objects;

public class Sandwich implements Product {
    private String name;
    private boolean isExtra;
    private SandwichSize sandwichSize;
    private BreadType breadType;
    private boolean isToasted;
    private HashSet<Sandwich> ingredients = new HashSet<>();

    public Sandwich(SandwichSize sandwichSize, BreadType breadType, boolean isToasted) {
        this.sandwichSize = sandwichSize;
        this.breadType = breadType;
        this.isToasted = isToasted;
    }

    public Sandwich(String name, boolean isExtra) {
        this.name = name;
        this.isExtra = isExtra;
    }

    public String getName() {
        return name;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public double getPrice(SandwichSize size) {
        return 0;
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

    @Override
    public double calculatePrice() {
        double total = sandwichSize.getPrice();

        for (Sandwich s : ingredients) {
            total += s.getPrice(sandwichSize);

        }

        return total;
    }

    //Using StringBuilder to append customizations of the sandwich for order summary.
    //Thought of just looping through the ingredients Hashset but every loop, it creates a brand new object vs. StringBuilder
    //it just builds one whole bigString object in memory. Saves time and memory
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  ").append(sandwichSize).append(" on ").append(breadType);

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

    @Override
    public int hashCode() {
        return Objects.hash(name, isExtra);
    }

    @Override
    // reference: https://www.geeksforgeeks.org/java/override-equalsobject-hashcode-method/
    public boolean equals(Object obj) {
        //"this" refers to the current object inside the equals parameters
        if (this == obj) {
            return true;
        }
        //defensive coding: making sure the obj is not null and classes are the same.
        if(obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        //type casting to Ingredient class to compare the fields directly to each other
        Sandwich that = (Sandwich) obj;

        return (this.isExtra == that.isExtra) && (Objects.equals(name, that.name));
    }


}
