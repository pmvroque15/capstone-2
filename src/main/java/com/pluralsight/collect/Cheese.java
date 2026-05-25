package com.pluralsight.collect;

import java.util.Objects;

public class Cheese extends Sandwich {
    private final String name;
    private final boolean isExtra;

    public Cheese(String name, SandwichSize sandwichSize, boolean isExtra) {
        super(sandwichSize);
        this.name = name;
        this.isExtra = isExtra;
    }

    public String getName() {
        return this.name;
    }

    public boolean isExtra() {
        return this.isExtra;
    }

    @Override
    public double getPrice() {

        if (this.isExtra) {
            return switch (super.getSize()) {
                case FOUR_INCH -> 1.05;
                case EIGHT_INCH -> 2.10;
                case TWELVE_INCH -> 3.15;
            };
        }

        return switch (super.getSize()) {
            case FOUR_INCH -> 0.75;
            case EIGHT_INCH -> 1.50;
            case TWELVE_INCH -> 2.25;
        };

    }

    @Override
    public String toString() {
        if (!isExtra) {
            return String.format("CHEESE: %s%nPRICE: $%.2f%n", getName(), getPrice());
        }
        return String.format("CHEESE: %s(extra)%nPRICE: $%.2f%n", getName(), getPrice());
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
        Cheese that = (Cheese) obj;

        return (this.isExtra == that.isExtra) && (Objects.equals(name, that.name));
    }


}
