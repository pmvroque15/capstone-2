package com.pluralsight.collect;

public class Meat extends Sandwich implements Product  {
    private final boolean isExtra;
    private final String name;
    private final SandwichSize sandwichSize;

    public Meat(String name, SandwichSize sandwichSize, BreadType breadType, boolean isExtra) {
        super(sandwichSize, breadType);
        this.isExtra = isExtra;
        this.name = name;
        this.sandwichSize = sandwichSize;
    }

    public Meat(String name, SandwichSize sandwichSize, boolean isExtra) {
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
        if (isExtra) {
            return switch (this.sandwichSize) {
                case FOUR_INCH -> 1.50;
                case EIGHT_INCH -> 3.00;
                case TWELVE_INCH -> 4.50;
            };
        }

        return switch (this.sandwichSize) {
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
}

