package com.pluralsight.collect;

import com.pluralsight.enums.BreadType;
import com.pluralsight.enums.DrinkSize;
import com.pluralsight.enums.SandwichSize;

public class DeliciousMain {
    public static void main(String[] args) {
       Sandwich sandwich = new Sandwich(SandwichSize.TWELVE_INCH, BreadType.WHITE, false);
       Ingredient meat = new Meat("Steak", false);
       Ingredient meat2 = new Meat("Steak", true);
       Ingredient cheese = new Cheese("Provolone", false);
       Ingredient cheese2 = new Cheese("Provolone", false);
       Ingredient lettuce = new RegularTopping("lettuce");
       Ingredient tomato = new RegularTopping("tomato");
       Chips chips = new Chips("Cheetos");
       Drink drink = new Drink(DrinkSize.MEDIUM, "Diet Coke");
       sandwich.addIngredient(meat);
       sandwich.addIngredient(meat2);
       sandwich.addIngredient(cheese);
       sandwich.addIngredient(lettuce);
       sandwich.addIngredient(tomato);
       sandwich.addIngredient(cheese2);


       Order order = new Order();

       order.addSandwich(sandwich);
       order.addChips(chips);
       order.addDrink(drink);

        System.out.println("ORDER SUMMARY:");
        System.out.println(sandwich);
        System.out.println(chips);
        System.out.println(drink);
        System.out.println("TOTAL: " + order.calculateTotal());


    }
}