package com.pluralsight.collect;

public class DeliciousMain {
    public static void main(String[] args) {
        Order order = new Order();
        Sandwich sandwich = new Sandwich(SandwichSize.EIGHT_INCH, BreadType.WHITE, true);
        Chips chips = new Chips();
        order.addSandwich(sandwich);
        order.addChips(chips);
    }
}