package com.pluralsight.collect;

import com.pluralsight.enums.SandwichSize;

public class RegularTopping extends Ingredient {
    public RegularTopping(String name) {
       //the boolean isExtra will always be FALSE in regular toppings
        super(name, false);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getPrice(SandwichSize size) {
        //always free
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Regular Toppings: %s%n", getName());
    }
}
