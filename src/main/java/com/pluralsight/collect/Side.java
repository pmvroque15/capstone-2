package com.pluralsight.collect;

public class Side extends Sandwich implements Product {

    public Side(String name) {
        super(name);
    }

    public String getName() {
        return super.getName();
    }

    public boolean isExtra() {
        return false;
    }

    @Override
    public double calculatePrice() {
        return 0;
    }

}
