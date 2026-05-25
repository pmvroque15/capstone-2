package com.pluralsight.collect;

public class Meat extends Sandwich {
    private final boolean isExtra;
    private final String name;

    public Meat(String name, SandwichSize sandwichSize, boolean isExtra) {
        super(sandwichSize);
        this.isExtra = isExtra;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean isExtra() {
        return this.isExtra;
    }

    @Override
    public double getPrice() {
        if (isExtra) {
            return switch (super.getSize()) {
                case FOUR_INCH -> 1.50;
                case EIGHT_INCH -> 3.00;
                case TWELVE_INCH -> 4.50;
            };
        }

        return switch (super.getSize()) {
            case FOUR_INCH -> 1.00;
            case EIGHT_INCH -> 2.00;
            case TWELVE_INCH -> 3.00;
        };
    }

    @Override
    public String toString() {
        if (!isExtra) {
            return String.format("MEAT: %s%nPRICE: $%.2f%n", getName(), getPrice());
        }
        return String.format("MEAT: %s(extra)%nPRICE: $%.2f%n", getName(), getPrice());
    }
}

