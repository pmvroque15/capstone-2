package com.pluralsight.collect;

public class Meat extends Sandwich {
    public Meat(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public double getPrice(RegularTopping.SandwichSize size) {
        if (isExtra()) {
            switch (size) {
                case FOUR_INCH:
                    return 1.50;
                case EIGHT_INCH:
                    return 3.00;
                case TWELVE_INCH:
                    return 4.50;
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

