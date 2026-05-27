package com.pluralsight.collect;
//Philly Cheese Steak
//o 8" white bread
//o Steak
//o American Cheese
//o Peppers
//o Mayo
//o Toasted
public class PhillyCheeseSteak extends Sandwich{

    public PhillyCheeseSteak() {
        super(SandwichSize.EIGHT_INCH, BreadType.WHITE, true);

    }

    public PhillyCheeseSteak addPhilly() {
        super.addIngredient(new Meat("Steak", sandwichSize, false));
        super.addIngredient(new Cheese("American Cheese", sandwichSize, false));
        String[] philly = {"Peppers", "Mayo"};
        for(String ingredient: philly) {
            super.addIngredient(new RegularTopping(ingredient));
        }

        return new PhillyCheeseSteak();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("    PHILLY CHEESE STEAK SANDWICH\n");
        sb.append("        ")
                .append(getSize())
                .append(" on ")
                .append(this.breadType)
                .append(" (Toasted)")
                .append("\n");

        //looping through hashset of ingredients and appending it to the sb object.
        for (Product p : ingredients) {

            if (p == null) {
                continue;
            }

            String name = p.getName();

            sb.append("                  -")
                    .append(name)
                    .append("\n");

        }
        //returns to the toString of sb object!
        return sb.toString();
    }
}
