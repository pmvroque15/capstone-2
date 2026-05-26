package com.pluralsight.collect;

//o 8" white bread
//o Bacon
//o Cheddar
//o Lettuce
//o Tomato
//o Ranch
//o Toasted
public class BLTSandwich extends Sandwich{

    public BLTSandwich() {
        super(SandwichSize.EIGHT_INCH, BreadType.WHITE, true);

        addBLT();
    }

    public void addBLT() {
       super.addIngredient(new Meat("Bacon", sandwichSize, false));
       super.addIngredient(new Cheese("Cheddar", sandwichSize, false));
        String[] BLT = {"Lettuce", "Tomatoes", "Pickles", "Ranch"};
        for(String ingredient: BLT) {
            super.addIngredient(new RegularTopping(ingredient));
        }
    }
}
