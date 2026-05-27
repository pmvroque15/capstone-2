package com.pluralsight.collect;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashSet;

public class DeliciousMain {
    public static void main(String[] args) {
//     UserInterface ui = new UserInterface();
//
//     ui.display();

        PhillyCheeseSteak BLT = new PhillyCheeseSteak();
        Order order = new Order();

        order.addProduct(BLT);

        System.out.println(order);
        }
}