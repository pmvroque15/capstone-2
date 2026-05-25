package com.pluralsight.collect;

import com.pluralsight.enums.SandwichSize;

public class Side extends Ingredient {

    public Side(String name) {
        super(name, false);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getPrice(SandwichSize size) {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Sauce: %s%n", getName());
    }
}
