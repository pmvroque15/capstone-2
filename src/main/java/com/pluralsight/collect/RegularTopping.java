package com.pluralsight.collect;

public class RegularTopping extends Sandwich {
    public RegularTopping(String name) {
       //the boolean isExtra will always be FALSE in regular toppings
        super(name, false);
    }

    @Override
    public String toString() {
        return String.format("Regular Toppings: %s%n", getName());
    }
}
