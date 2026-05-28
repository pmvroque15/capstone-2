package com.pluralsight.collect;

public class DeliciousMain {
    public static void main(String[] args) {
//        UserInterface ui = new UserInterface();
//
//        ui.display();

        PhillyCheeseSteak blt = new PhillyCheeseSteak();

        Order order = new Order();
        order.addProduct(blt);
        order.setTipsAmount(10);
        order.getTipsAmount();
        System.out.println(order.toString());
    }
}