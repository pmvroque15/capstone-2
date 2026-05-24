package com.pluralsight.collect;

import com.pluralsight.enums.SandwichSize;

import java.util.Objects;

public abstract class Ingredient {
    private String name;
    private boolean isExtra;

    public Ingredient(String name, boolean isExtra) {
        this.name = name;
        this.isExtra = isExtra;
    }

    public String getName() {
        return name;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public abstract double getPrice(SandwichSize size);
    //it's like organizes the hashsets, putting in separate buckets by its name and
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
        Ingredient that = (Ingredient) obj;

        return (this.isExtra == that.isExtra) && (Objects.equals(name, that.name));
    }

}
