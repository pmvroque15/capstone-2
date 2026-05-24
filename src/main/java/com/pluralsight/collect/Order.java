package com.pluralsight.collect;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private ArrayList<Product> sandwiches = new ArrayList<>();
    private ArrayList<Product> drinks = new ArrayList<>();
    private ArrayList<Product> chips = new ArrayList<>();
    private LocalDateTime orderTimeAndDate = LocalDateTime.now();

    public void addSandwich(Product product){
        sandwiches.add(product);
    }

    public void addDrink(Product product) {
        drinks.add(product);
    }

    public void addChips(Product product) {
        chips.add(product);
    }

    public void removeSandwich(Product product) {
        sandwiches.remove(product);
    }

    public void removeDrink(Product product) {
        drinks.remove(product);
    }

    public void removeChips(Product product) {
        chips.remove(product);
    }

    //this method makes sure that if the customer orders no sandwiches at all, they are REQUIRED to order chips or drinks
    public boolean isValid() {
        if(sandwiches.isEmpty()) {
            return !chips.isEmpty() || !drinks.isEmpty();
        }

        return true;
    }

    public double calculateTotal() {
        double total = 0;
        //adding isValid(), to make sure that the customer will buy chips or drink
        for(Product s: sandwiches) {
            total += s.calculatePrice();
        }

        for(Product c: chips) {
            total += c.calculatePrice();
        }

        for(Product d: drinks) {
            total += d.calculatePrice();
        }

        return total;
    }


}
