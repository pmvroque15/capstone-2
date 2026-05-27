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
        super.addIngredient(new Meat("Bacon", sandwichSize, false));
        super.addIngredient(new Cheese("Cheddar", sandwichSize, false));
        String[] BLT = {"Lettuce", "Tomatoes", "Pickles", "Ranch"};
        for(String ingredient: BLT) {
            super.addIngredient(new RegularTopping(ingredient));
        }

    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BLT SANDWICH\n");
        sb.append(getSize()).append(" on ").append(this.breadType).append(" (Toasted)")
                .append("\n");

        //looping through hashset of ingredients and appending it to the sb object.
        for (Product p : ingredients) {

            if (p == null) {
                continue;
            }

            String name = p.getName();

            sb.append(String.format("  - %-30s %5.2f",name, p.calculatePrice())).append("\n");

        }
        //returns to the toString of sb object!
        return sb.toString();
    }
}
