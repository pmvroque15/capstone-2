package com.pluralsight.collect;

import com.pluralsight.enums.SandwichSize;

public class Cheese extends Ingredient {
    public Cheese(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getPrice(SandwichSize size) {

        if (isExtra()) {
            switch (size) {
                case FOUR_INCH:
                    return 0.30;
                case EIGHT_INCH:
                    return 0.60;
                case TWELVE_INCH:
                    return 0.90;
            }
        }

        switch (size) {
            case FOUR_INCH:
                return 0.75;
            case EIGHT_INCH:
                return 1.50;
            case TWELVE_INCH:
                return 2.25;
        }

        return 0;
    }

    @Override
    public String toString() {
        return String.format("Cheese: %s%n", getName());
    }


}
