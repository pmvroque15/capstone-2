package com.pluralsight.collect;

public class Cheese extends Sandwich {
    public Cheese(String name, boolean isExtra) {
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
                    return 1.05;
                case EIGHT_INCH:
                    return 2.10;
                case TWELVE_INCH:
                    return 3.15;
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
