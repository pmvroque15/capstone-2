package com.pluralsight.collect;

public enum SandwichSize {
    FOUR_INCH(5.50),
    EIGHT_INCH(7.00),
    TWELVE_INCH(8.50);
    private final double price;
    //reference for this approach: https://stackoverflow.com/questions/40094997/assign-enum-values-in-java
    SandwichSize(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
}