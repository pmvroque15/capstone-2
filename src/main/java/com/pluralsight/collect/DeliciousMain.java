package com.pluralsight.collect;

public class DeliciousMain {
    public static void main(String[] args) {
       Sandwich sandwich = new Sandwich(SandwichSize.TWELVE_INCH, BreadType.WHOLE, false);
       Sandwich meat2 = new Meat("Steak", true);
       Sandwich cheese = new Cheese("Provolone", false);
       Sandwich cheese2 = new Cheese("Provolone", false);
       Sandwich lettuce = new RegularTopping("lettuce");
       Sandwich tomato = new RegularTopping("tomato");
       Chips chips = new Chips("Cheetos");
       Drink drink = new Drink(DrinkSize.MEDIUM);
       sandwich.addIngredient(meat2);
       sandwich.addIngredient(cheese);
       sandwich.addIngredient(lettuce);
       sandwich.addIngredient(tomato);
       sandwich.addIngredient(cheese2);

//      UserInterface ui = new UserInterface();
//
//      ui.display();



        Order order = new Order();


        System.out.println("ORDER SUMMARY:");
        System.out.println(sandwich);
        System.out.println(chips);
        System.out.println(drink);
        System.out.println("TOTAL: " + order.calculateTotal());



//       Sandwich sandwich2 = new Sandwich(
//               SandwichSize.EIGHT_INCH,
//               BreadType.WHEAT,
//               true
//       );
//
//       Ingredient turkey = new Meat("Turkey", false);
//       Ingredient bacon = new Meat("Bacon", true);
//       Ingredient swiss = new Cheese("Swiss", false);
//       Ingredient onions = new RegularTopping("Onions");
//       Ingredient peppers = new RegularTopping("Peppers");
//
//       sandwich2.addIngredient(turkey);
//       sandwich2.addIngredient(bacon);
//       sandwich2.addIngredient(swiss);
//       sandwich2.addIngredient(onions);
//       sandwich2.addIngredient(peppers);
//
//       Drink drink2 = new Drink(DrinkSize.SMALL, "Sprite");
//       Chips chips2 = new Chips("Doritos");
//
//
//       Order order = new Order();
//
//       order.addSandwich(sandwich);
//       order.addChips(chips);
//       order.addDrink(drink);
//       order.addSandwich(sandwich2);
//       order.addDrink(drink2);
//       order.addChips(chips2);
//
//       order.completeOrder();



    }
}