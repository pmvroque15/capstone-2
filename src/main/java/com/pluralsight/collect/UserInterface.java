package com.pluralsight.collect;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);

    public void display() {
        homeScreen();
    }

    public void homeScreen() {
        String mainMenu = """
                      DELIcious Sandwiches
                "Built Different. Stacked right."
                --------------------------------
                        Select an option:
                        1 - New Order
                        0 - Exit
                """;

        boolean running = true;
        do {

            System.out.println(mainMenu);
            System.out.println("What can I get started with you? ");
            int input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case 1:
                    newOrderRequest();
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

    }

    public void checkoutScreen() {

    }

    public void exit() {
        System.out.println("Thank you for using the app!");
    }

    private void newOrderRequest() {
        String orderScreen = """
                
                          Order Screen
                --------------------------------
                        Select an option:
                        1 - Add Sandwich
                        2 - Add Drink
                        3 - Add Chips
                        4 - Checkout
                        0 - Cancel Order
                """;

        boolean running = true;
        do {
            System.out.println(orderScreen);
            System.out.println("What would you like? ");
            int input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case 1:
                    createASandwichOrderRequest();
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
        } while(running);
    }

    private void checkoutRequest() {
        System.out.println("TEST checkout");
    }

    private void createAChipsOrderRequest() {
        System.out.println("TEST chips order");

    }

    private void createADrinkOrderRequest() {
        System.out.println("TEST drink order");
    }

    private void createASandwichOrderRequest() {
        System.out.println("TEST sandwich order");
    }

}


