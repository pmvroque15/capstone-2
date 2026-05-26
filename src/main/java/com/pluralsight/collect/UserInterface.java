package com.pluralsight.collect;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class UserInterface {
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
                case 1:
                    Product sandwich = createASandwichOrder();

                    if (sandwich != null) {
                        order.addProduct(sandwich);
                        System.out.println("TEST: Sandwich!");
                    }
                    break;
                case 2:
                    Drink drink = createADrinkOrder();
                    if (drink != null) {
                        order.addProduct(drink);
                    }

                    break;
                case 3:
                    Chips chips = createAChipsOrder();

                    if (chips != null) {
                        order.addProduct(chips);
                    }
                    System.out.println("TEST: chips!");
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
//        //todo: Ask David if it's better to make a method for this. CreateASandwich class?
        SandwichSize size = chooseSandwichSize();
        BreadType breadType = chooseBreadType();
        boolean isToasted = isToasted();
        Sandwich sandwich = new Sandwich(size, breadType, isToasted);

        Meat meat = chooseAMeat(size);
        sandwich.addIngredient(meat);

        Cheese cheese = chooseACheese(size);
        sandwich.addIngredient(cheese);

        HashSet<RegularTopping> regularToppings = chooseRegularToppings();
        for (RegularTopping i : regularToppings) {
            sandwich.addIngredient(i);
        }

        Sauce sauce = chooseASauce();
        sandwich.addIngredient(sauce);

        Side side = chooseASide();
        sandwich.addIngredient(side);

//        //todo make a defensive code make sure arguments are NOT null
        return sandwich;

    }

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

    public HashSet<RegularTopping> chooseRegularToppings() {
        HashSet<RegularTopping> toppingsList = new HashSet<>();
        String[] toppings = {"Lettuce", "Peppers", "Onions",
                "Tomatoes", "Jalapeños", "Cucumbers",
                "Pickles", "Guacamole", "Mushrooms"};

        boolean running = true;
        while (running) {
            String topping = chooseFromMenu("Pick a topping: ", toppings);

            if (topping.isBlank()) {
                continue;
            }
            boolean duplicate = false;

            for (RegularTopping t : toppingsList) {
                if (topping.equalsIgnoreCase(t.getName())) {
                    System.err.printf("Yo, what's up with the %s? Try again.\n", t.getName());

                    duplicate = true;
                    break;
                }
            }


            if (!duplicate) {
                toppingsList.add(new RegularTopping(topping));
            }

            System.out.println("Do you want to add another topping? y/n");

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

        System.out.printf("Do you want extra of %s? y/n", cheese);
        boolean isExtra = scanner.nextLine().equalsIgnoreCase("y");

        return new Cheese(cheese, size, isExtra);
    }

    public Boolean isToasted() {
        System.out.println("Would you like the sandwich toasted? (Yes or No)");
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

        System.out.printf("Do you want extra of %s? y/n", meat);
        boolean isExtra = scanner.nextLine().equalsIgnoreCase("y");

        return new Meat(meat, size, isExtra);
    }

    //helper method
    public String chooseFromMenu(String prompt, String[] options) {

        while (true) {
            System.out.println(prompt);

            for (String option : options) {
                System.out.println("- " + option);
            }

            System.out.println("(Please Enter to skip)");

            String input = scanner.nextLine();

            if (input.isEmpty()) {
                return "";
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
        System.out.println("What you like to add a bag of chips? (Enter to skip)");
        String input = scanner.nextLine();

        if (input.isBlank()) {
            return null;
        }

        return new Chips();
    }

    public Drink createADrinkOrder() {
        //What if the user wants more than one drink?

        System.out.println("Would you like a drink? (y/n or Enter to skip)");
        String input = scanner.nextLine();

        if (input.isBlank() || input.equalsIgnoreCase("n")) {
            return null;
        }

        DrinkSize size = null;

        while (size == null) {
            try {
                if (input.equalsIgnoreCase("y")) {
                    System.out.println("What size? (Small, Medium, Large)");
                    size = DrinkSize.valueOf(scanner.nextLine().toUpperCase());
                }
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

        System.out.println("Order Canceled");
    }

    public void checkout(Order order) {
//        //todo Make sure the math is right AND it populates accurately.
//        //todo render the order then confirms or cancel the order before completing the order
//        order.completeOrder();
        System.out.println(order);
    }


}


