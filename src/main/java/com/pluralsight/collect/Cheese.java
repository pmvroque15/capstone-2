package com.pluralsight.collect;

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


}
