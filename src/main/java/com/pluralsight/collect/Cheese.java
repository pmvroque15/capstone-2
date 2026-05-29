package com.pluralsight.collect;

public class Cheese extends Sandwich implements Product{
    private final String name;
    private final boolean isExtra;
    private final SandwichSize sandwichSize;

    public Cheese(String name, SandwichSize sandwichSize, BreadType breadType, boolean isExtra) {
        super(sandwichSize, breadType);
        this.name = name;
        this.isExtra = isExtra;
        this.sandwichSize = sandwichSize;
    }

    public Cheese(String name, SandwichSize sandwichSize, boolean isExtra) {
        super(sandwichSize);
        this.name = name;
        this.sandwichSize = sandwichSize;
        this.isExtra = isExtra;
    }


    public String getName() {
        return this.name;
    }

    public boolean isExtra() {
        return this.isExtra;
    }

    @Override
    public double calculatePrice() {

        if (this.isExtra) {
            return switch (sandwichSize) {
                case FOUR_INCH -> 1.05;
                case EIGHT_INCH -> 2.10;
                case TWELVE_INCH -> 3.15;
            };
        }

        return switch (sandwichSize) {
            case FOUR_INCH -> 0.75;
            case EIGHT_INCH -> 1.50;
            case TWELVE_INCH -> 2.25;
        };

    }
}
