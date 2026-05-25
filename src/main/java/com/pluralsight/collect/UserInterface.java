package com.pluralsight.collect;
import com.pluralsight.enums.BreadType;
import com.pluralsight.enums.SandwichSize;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);

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

    private void orderScreen() {

        boolean running = true;
        do {
            MenuStrings.orderMenuDisplay();
            System.out.println("What would you like? ");
            int input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case 1:
                    createASandwich();
                    break;
                case 2:
                    createADrinkOrderRequest();
                    break;
                case 3:
                    createAChipsOrderRequest();
                    break;
                case 4:
                    checkoutRequest();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.err.printf("Invalid input: %s. Try again.", input);
            }
        } while (running);
    }

    public Sandwich createASandwich() {
        //todo: clean this, make each prompt a new method
        SandwichSize sandwichSize = chooseSandwichSize();
        BreadType breadType = chooseBreadType();
        boolean isToasted = isToasted();
        Ingredient meat = chooseAMeat();


        System.out.println("Cheese: ");
        System.out.println("Other toppings: ");
        System.out.println("Select sauces: ");


        //todo make a defensive code make sure arguments are NOT null
        return new Sandwich(sandwichSize, breadType, isToasted);

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
        //todo clean the default err message it should show BEFORE the prompt if the user typed invalid input
        do {
            System.out.println("Select your bread: (Whole, Wheat, Wrap, or Rye) ");
            String bread = scanner.nextLine().toUpperCase();
            switch (bread) {
                case "WHITE":
                    breadType = BreadType.WHITE;
                    running = false;
                    break;
                case "RYE":
                    breadType = BreadType.RYE;
                    running = false;
                    break;
                case "WHOLE":
                    breadType = BreadType.WHEAT;
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

    public Ingredient chooseAMeat() {
        boolean running = true;
        String meat = null;

            String[] meats = {"Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon"};
            System.out.println("Choose your protein: ");
            for (String m: meats) {
                System.out.println(m);
            }
            String input = scanner.nextLine();

            for (String m: meats) {
                if(input.equalsIgnoreCase(m)) {
                    meat = m;
                }
            }

            System.out.printf("Do you want extra of %s? y/n", meat);
            String anotherInput = scanner.nextLine();
            boolean isExtra = anotherInput.equalsIgnoreCase("y");

        return new Meat(meat, isExtra);
    }

    private void createAChipsOrderRequest() {
        System.out.println("TEST chips order");

    }

    private void createADrinkOrderRequest() {
        System.out.println("TEST drink order");
    }

    public void checkoutScreen() {

    }

    public void exit() {
        System.out.println("Thank you for using the app!");
    }


    private void checkoutRequest() {
        System.out.println("TEST checkout");
    }


}


