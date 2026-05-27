package com.pluralsight.collect;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner = new Scanner(System.in);
    private Order order;

    public void display() {
        homeScreen();
    }

    public void homeScreen() {

        boolean running = true;
        do {

            try {
                MenuStrings.mainMenuDisplay();
                System.out.println("What can I get started with you? ");
                int input = Integer.parseInt(scanner.nextLine().trim());
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
            } catch (NumberFormatException e) {
                System.err.println("This is New York, we move fast. Stop wasting our time and type a number!");
            }
        } while (running);
    }

    public void orderScreen() {

        order = new Order();
        boolean running = true;
        do {
            try {

                MenuStrings.orderMenuDisplay();

                System.out.println("What would you like? ");

                int input = Integer.parseInt(scanner.nextLine().trim());

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
                    case 5:
                        chooseASignatureSandwich(order);
                        break;
                    case 0:
                        cancelOrder(order);
                        running = false;

                        break;
                    default:
                        System.err.printf("Invalid input: %s. Try again.", input);
                }
            } catch (NumberFormatException e) {
                System.err.println("Bro the bodega cat is judging you right now. TYPE. A. NUMBER.");
            }
        } while (running);
    }

    public void chooseASignatureSandwich(Order order) {
        boolean runnning = true;

        do {
            try {

                MenuStrings.signaturesSandwichesDisplay();
                String input = scanner.nextLine().trim().toUpperCase();
                switch (input) {
                    case "BLT":
                        BLTSandwich bltSandwich = new BLTSandwich();
                        order.addProduct(bltSandwich);

                        System.out.println("BLT sandwich is successfully added to your cart.");
                        break;
                    case "PHILLY":
                        PhillyCheeseSteak phillyCheeseSteak = new PhillyCheeseSteak();

                        order.addProduct(phillyCheeseSteak);
                        System.out.println("Philly Cheese Steak sandwich is successfully added to your cart.");
                        break;
                    case "0":
                        runnning = false;
                        break;
                    default:
                        System.err.println("Invalid input. Try again.");

                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Try again.");
            }
        } while (runnning);
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
        if (meat != null) {
            sandwich.addIngredient(meat);
        }
        //Same with Cheese
        Cheese cheese = chooseACheese(size);
        if (cheese != null) {
            sandwich.addIngredient(cheese);
        }
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

        if (side == null) {
            return null;
        }

        return new Side(side);
    }

    public Sauce chooseASauce() {

        String[] sauces = {"Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette"};

        String sauce = chooseFromMenu("Choose your sauce: ", sauces);

        if (sauce == null) {
            return null;
        }

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

            if (!topping.isBlank()) {
                boolean added = toppingsList.add(new RegularTopping(topping));
                if (!added) {
                    System.err.printf("Yo, what's up with your %s? Try another topping.", topping);
                }
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

        if (cheese == null) {
            return null;
        }

        System.out.printf("Do you want extra of %s? (y/n):", cheese);

        boolean isExtra = scanner.nextLine().equalsIgnoreCase("y");

        return new Cheese(cheese, size, isExtra);
    }

    public Boolean isToasted() {
        System.out.println("Would you like the sandwich toasted? (y/n):");
        String toasted = scanner.nextLine();

        if (toasted.equalsIgnoreCase("y")) {
            return true;
        } else if (toasted.equalsIgnoreCase("n")) {
            return false;
        } else {
            System.err.println("Invalid input, Please enter 'y' or 'n'");
            return isToasted();
        }
    }

    public SandwichSize chooseSandwichSize() {
        SandwichSize sandwichSize = null;
        try {
            boolean running = true;


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
        } catch (NumberFormatException e) {
            System.err.println("Yo, type a number!");
        }

        return sandwichSize;
    }

    public BreadType chooseBreadType() {
        BreadType breadType = null;

        boolean running = true;
        do {
            System.out.println("Select your bread: (Whole, Wheat, Wrap, or Rye) ");
            String bread = scanner.nextLine().toUpperCase();
            switch (bread) {
                case "WHEAT":
                    breadType = BreadType.WHITE;
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

        if (meat == null) {
            return null;
        }

        System.out.printf("Do you want extra of %s? (y/n):", meat);
        boolean isExtra = scanner.nextLine().equalsIgnoreCase("y");
        return new Meat(meat, size, isExtra);
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
        ReceiptManager receiptManager = new ReceiptManager(order);

        receiptManager.deleteReceipt();
        order.clearProducts();

        System.out.println("Order is canceled.");

    }

    public void addTips(Order order) {

        System.out.println("Would you like to add a tip? (y/n):");
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("n")) {
            order.setAmount(0);
        } else if (input.equalsIgnoreCase("y")) {
            boolean isValid = false;
            do {
                try {
                    System.out.println("Tip:  $");
                    double inputTip = Double.parseDouble(scanner.nextLine().trim());
                    order.setAmount(inputTip);

                    System.out.println("Tip added to the total!");
                    isValid = true;
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input. Try again.");
                }
            } while (!isValid);
        }
    }

    public void checkout(Order order) {
        if (order.getProducts().isEmpty()) {
            System.err.println("Your cart is empty. Add an item to proceed.");
            return;
        }

        if(order.getAmount() == 0) {
            addTips(order);
        }

        System.out.println(order);
        System.out.println("Place your order? Type \"y\" to check out, \"n\" to go back to the menu, \"x\" to cancel the order.");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("y")) {
            order.completeOrder();
            System.out.println("Order placed successfully! Thank you!");

        } else if (input.equalsIgnoreCase("x")) {
            cancelOrder(order);
        } else {
            System.out.println("Returning to the menu...");
        }
    }
}


