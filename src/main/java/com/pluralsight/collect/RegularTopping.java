package com.pluralsight.collect;

import java.util.Objects;

public class RegularTopping implements Product {
    private final String name;

    public RegularTopping(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isExtra() {
        return false;
    }

    @Override
    public double calculatePrice() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Regular Topping: %s%nPRICE: $%.2f%n", getName(), calculatePrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
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
        RegularTopping that = (RegularTopping) obj;

        return Objects.equals(name, that.name);
    }



}
