package com.pluralsight.collect;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class UserInterface {
    //todo make defensive coding on each prompts
    private final Scanner scanner = new Scanner(System.in);

    public void display() {
        homeScreen();
    }

    public void homeScreen() {

        boolean running = true;
        do {
            MenuStrings.mainMenuDisplay();
            System.out.println("What can I get started with you? ");
            int input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case 1:
                    orderScreen();
                    break;
                case 0:
                    exit();
                    running = false;
                    break;
                default:
                    System.err.printf("Invalid input: %s. Try again.", input);
            }
        } while (running);
    }

    public void orderScreen() {
        Order order = new Order();

        boolean running = true;

        do {

            MenuStrings.orderMenuDisplay();

            System.out.println("What would you like? ");

            int input = Integer.parseInt(scanner.nextLine());

            switch (input) {
               //Each case makes an instance of an object and adds to the products arrayList, if it was not null.
                case 1:
                    Product sandwich = createASandwichOrder();

                    if (sandwich != null) {
                        order.addProduct(sandwich);
                        System.out.println("Sandwich is successfully added to your cart.");
                    }
                    break;
                case 2:
                    Drink drink = createADrinkOrder();

                    if (drink != null) {
                        order.addProduct(drink);
                        System.out.println("Drink is successfully added to your cart.");
                    }
                    break;
                case 3:
                    Chips chips = createAChipsOrder();

                    if (chips != null) {
                        order.addProduct(chips);
                        System.out.println("Chips is successfully added to your cart.");
                    }
                    break;
                case 4:
                    checkout(order);

                    break;
                case 0:
                    cancelOrder(order);
                    running = false;

                    break;
                default:
                    System.err.printf("Invalid input: %s. Try again.", input);
            }
        } while (running);
    }

    public Product createASandwichOrder() {
     //todo: Ask David if it's better to make a method for this. CreateASandwich class?

        //For making the Sandwich base
        SandwichSize size = chooseSandwichSize();
        BreadType breadType = chooseBreadType();
        boolean isToasted = isToasted();
        Sandwich sandwich = new Sandwich(size, breadType, isToasted);

        //Making an instance of meat through the method chooseAMeat(size) and adding it to the ArrayList of products
        Meat meat = chooseAMeat(size);
        sandwich.addIngredient(meat);

        //Same with Cheese
        Cheese cheese = chooseACheese(size);
        sandwich.addIngredient(cheese);

        //Making a Hashset for toppings because it helps for duplication and separates from the list pf products since user can order multiple toppings.
        HashSet<RegularTopping> regularToppings = chooseRegularToppings();
        for (RegularTopping i : regularToppings) {
            sandwich.addIngredient(i);
        }

        //Sauce
        Sauce sauce = chooseASauce();
        sandwich.addIngredient(sauce);
        //Side
        Side side = chooseASide();
        sandwich.addIngredient(side);

        return sandwich;

    }

    //for sauce and sides, made an array to iterate through the method chooseFromMenu()
    //that way, user can see what is the available choices of each category
    public Side chooseASide() {

        String[] sides = {"Au jus", "Sauce"};

        String side = chooseFromMenu("Choose a side: ", sides);

        return new Side(side);
    }

    public Sauce chooseASauce() {

        String[] sauces = {"Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette"};

        String sauce = chooseFromMenu("Choose your sauce: ", sauces);

        return new Sauce(sauce);
    }

    //returning hashset of toppings to reuse the data to the createASandwich()
    public HashSet<RegularTopping> chooseRegularToppings() {

        HashSet<RegularTopping> toppingsList = new HashSet<>();

        String[] toppings = {"Lettuce", "Peppers", "Onions",
                "Tomatoes", "Jalapeños", "Cucumbers",
                "Pickles", "Guacamole", "Mushrooms"};

        boolean running = true;

        while (running) {

            String topping = chooseFromMenu("Pick a topping: ", toppings);

            if (topping.isBlank()) {
                running = false;
            }

            boolean duplicate = false;

            for (RegularTopping t : toppingsList) {
                if (topping.equalsIgnoreCase(t.getName())) {
                    System.err.printf("Yo, what's up with the %s? Try again.\n", t.getName());

                    duplicate = true;
                    break;
                }
            }

            //if not a duplicated, add it to a new instance of RegularTopping
            if (!duplicate) {
                toppingsList.add(new RegularTopping(topping));
            }

            System.out.println("Do you want to add another topping? (y/n)");

            String input = scanner.nextLine();

            if (!input.equalsIgnoreCase("y")) {
                running = false;
            }

        }
        return toppingsList;
    }

    public Cheese chooseACheese(SandwichSize size) {

        String[] kindOfCheese = {"American", "Provolone", "Cheddar", "Swiss"};

        String cheese = chooseFromMenu("Pick your cheese", kindOfCheese);

        //if input is not null, return the instance of Cheese, otherwise, return null
        if (cheese != null) {

            System.out.printf("Do you want extra of %s? y/n", cheese);

            boolean isExtra = scanner.nextLine().equalsIgnoreCase("y");

            return new Cheese(cheese, size, isExtra);
        }

        return null;

    }

    public Boolean isToasted() {
        System.out.println("Would you like the sandwich toasted? (y/n)");
        String toasted = scanner.nextLine();

        return toasted.equalsIgnoreCase("Yes");
    }

    public SandwichSize chooseSandwichSize() {
        boolean running = true;

        SandwichSize sandwichSize = null;

        do {

            System.out.println("Sandwich size: (4, 8, 12)");
            int size = Integer.parseInt(scanner.nextLine());

            switch (size) {
                case 4:
                    sandwichSize = SandwichSize.FOUR_INCH;
                    running = false;
                    break;
                case 8:
                    sandwichSize = SandwichSize.EIGHT_INCH;
                    running = false;
                    break;
                case 12:
                    sandwichSize = SandwichSize.TWELVE_INCH;
                    running = false;
                    break;
                default:
                    System.err.println("Invalid input. Please choose and type the available sizes: 4, 8, or 12 inches.");
                    break;

            }
        } while (running);

        return sandwichSize;
    }

    public BreadType chooseBreadType() {

        boolean running = true;
        BreadType breadType = null;
//        //todo clean the default err message it should show BEFORE the prompt if the user typed invalid input
        do {
            System.out.println("Select your bread: (Whole, Wheat, Wrap, or Rye) ");
            String bread = scanner.nextLine().toUpperCase();
            switch (bread) {
                case "WHEAT":
                    breadType = BreadType.WHEAT;
                    running = false;
                    break;
                case "RYE":
                    breadType = BreadType.RYE;
                    running = false;
                    break;
                case "WHOLE":
                    breadType = BreadType.WHOLE;
                    running = false;
                    break;
                case "WRAP":
                    breadType = BreadType.WRAP;
                    running = false;
                    break;
                default:
                    System.err.println("Invalid input. Please choose and type the available bread type: Whole, White, Wrap, or Rye.");
                    break;

            }
        } while (running);

        return breadType;
    }

    public Meat chooseAMeat(SandwichSize size) {

        String[] meats = {"Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon"};

        String meat = chooseFromMenu("Choose your protein", meats);

        if (meat != null) {
            System.out.printf("Do you want extra of %s? y/n", meat);
            boolean isExtra = scanner.nextLine().equalsIgnoreCase("y");
            return new Meat(meat, size, isExtra);
        }

        return null;
    }

    //HELPER METHOD: Going back to Sides and Sauces, made a method instead of repeating the logic.
    public String chooseFromMenu(String prompt, String[] options) {

        while (true) {
            System.out.println(prompt);

            for (String option : options) {
                System.out.println("- " + option);
            }

            System.out.println("(Please Enter to skip)");

            String input = scanner.nextLine();

            if (input.isEmpty()) {
                return null;
            }

            for (String option : options) {
                if (input.equalsIgnoreCase(option)) {
                    return option;
                }
            }

            System.err.println("Invalid selection.");
        }
    }

    public Chips createAChipsOrder() {
        //Just returned the instance of Chips since it does not need anything else and all chips are $1.50
        return new Chips();
    }

    public Drink createADrinkOrder() {

        DrinkSize size = null;

        while (size == null) {
            try {
                System.out.println("What size? (Small, Medium, Large)");
                size = DrinkSize.valueOf(scanner.nextLine().toUpperCase());

            } catch (IllegalArgumentException e) {
                System.err.println("Invalid size. Try again.");
            }
        }

        return new Drink(size);
    }

    public void exit() {
        System.out.println("Thank you for using the app!");
    }

    public void cancelOrder(Order order) {
        order.cancelOrder();

        System.out.println("Order Canceled.");
    }

    public void checkout(Order order) {
        System.out.println(order);
        System.out.println("Place your order? Type \"y\" to check out, \"n\" to go back to the menu, \"x\" to cancel the order.");

        String input = scanner.nextLine();

        if(input.equalsIgnoreCase("y")) {
            order.completeOrder();
            System.out.println("Order places successfully! Thank you!");
        } else if(input.equalsIgnoreCase("x")) {
            cancelOrder(order);
            System.out.println("Order is canceled.");
        }
        else {
            System.out.println("Returning to the menu...");
        }
    }


}


