package com.pluralsight.collect;

public class Chips implements Product{
    //The customer can have freedom to choose what kind of "chip type" according to the instructions, and all chips will be the same price.

    @Override
    public double calculatePrice(){
        return 1.50;
    }

    @Override
    public String getName() {
        return "CHIPS";
    }

    @Override
    public boolean isExtra() {
        return false;
    }

    @Override
    public String toString() {
        return String.format("%-40s 1.50", getName());
    }
}
