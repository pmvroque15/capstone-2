package com.pluralsight.collect;

public class Sauce extends Ingredient{
    public Sauce(String name) {
        //Always free and it comes with a sauce
        super(name, false);
    }

    @Override
    public double getPrice(SandwichSize size) {
        return 0;
    }
}
