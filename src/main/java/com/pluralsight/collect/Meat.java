package com.pluralsight.collect;

import com.pluralsight.enums.SandwichSize;

public class Meat extends Ingredient {
    public Meat(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(SandwichSize size) {
        if (isExtra()) {
            switch (size) {
                case FOUR_INCH:
                    return 0.50;
                case EIGHT_INCH:
                    return 1.00;
                case TWELVE_INCH:
                    return 1.50;
            }
        }

        switch (size) {
            case FOUR_INCH:
                return 1.00;
            case EIGHT_INCH:
                return 2.00;
            case TWELVE_INCH:
                return 3.00;
        }
        return 0;
    }

    @Override
    public String toString() {
        if(!isExtra()) {
            return getName();
        }
       return String.format("Extra: %s%n", getName());
    }
}

