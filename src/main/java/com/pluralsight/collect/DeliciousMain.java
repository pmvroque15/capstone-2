package com.pluralsight.collect;

public class DeliciousMain {
    public static void main(String[] args) {
        Sandwich sandwich = new Sandwich(SandwichSize.FOUR_INCH, BreadType.WRAP, true);

        sandwich.addIngredient(new Meat("steak", false));
        sandwich.addIngredient(new Meat("steak", true));
        sandwich.addIngredient(new Cheese("provolone", false));
        sandwich.addIngredient(new Cheese("provolone", true));

        System.out.println(sandwich.calculatePrice());

        Order order = new Order();
        order.addSandwich(sandwich);

        Drink drink = new Drink(DrinkSize.MEDIUM);

        order.addDrink(drink);

        System.out.println(order.calculateTotal());
    }
}