package com.pluralsight.collect;

public class Meat extends Ingredient{
    public Meat(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    double getPrice() {
        return 0;
    }
}
