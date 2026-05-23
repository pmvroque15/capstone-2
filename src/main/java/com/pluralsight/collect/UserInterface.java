package com.pluralsight.collect;

import java.awt.*;
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

    private void createASandwichOrderRequest() {

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


