package com.pluralsight.collect;

//Philly Cheese Steak
//o 8" white bread
//o Steak
//o American Cheese
//o Peppers
//o Mayo
//o Toasted
public class PhillyCheeseSteak extends Sandwich {

    public PhillyCheeseSteak() {
        super(SandwichSize.EIGHT_INCH, BreadType.WHITE, true);
    }

    public void addDefaultIngredients() {
        super.addIngredient(new Meat("Steak", SandwichSize.EIGHT_INCH, BreadType.WHITE, true));
        super.addIngredient(new Cheese( "American Cheese", SandwichSize.EIGHT_INCH,BreadType.WHITE, false));
        String[] philly = {"Peppers", "Mayo"};

        for (String ingredient : philly) {
            super.addIngredient(new RegularTopping(ingredient));
        }
    }


}
