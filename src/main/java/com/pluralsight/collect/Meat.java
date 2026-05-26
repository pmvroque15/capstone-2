package com.pluralsight.collect;

import java.util.Objects;

public class Meat implements Product {
    private final boolean isExtra;
    private final String name;
    private final SandwichSize sandwichSize;

    public Meat(String name, SandwichSize sandwichSize, boolean isExtra) {
        this.isExtra = isExtra;
        this.name = name;
        this.sandwichSize = sandwichSize;
    }


    public String getName() {
        return this.name;
    }

    public boolean isExtra() {
        return this.isExtra;
    }

    @Override
    public double calculatePrice() {
        if (isExtra) {
            return switch (this.sandwichSize) {
                case FOUR_INCH -> 1.50;
                case EIGHT_INCH -> 3.00;
                case TWELVE_INCH -> 4.50;
            };
        }

        return switch (getSandwichSize()) {
            case FOUR_INCH -> 1.00;
            case EIGHT_INCH -> 2.00;
            case TWELVE_INCH -> 3.00;
        };
    }

    @Override
    public String toString() {
        if (!isExtra) {
            return String.format("MEAT: %s%nPRICE: $%.2f%n", getName(), calculatePrice());
        }
        return String.format("MEAT: %s(extra)%nPRICE: $%.2f%n", getName(), calculatePrice());
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
        Meat that = (Meat) obj;

        return (this.isExtra == that.isExtra) && (Objects.equals(name, that.name));
    }

    public SandwichSize getSandwichSize() {
        return sandwichSize;
    }
}

