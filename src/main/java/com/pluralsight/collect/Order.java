package com.pluralsight.collect;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private ArrayList<Product> sandwiches = new ArrayList<>();
    private ArrayList<Product> drinks = new ArrayList<>();
    private ArrayList<Product> chips = new ArrayList<>();
    private LocalDateTime orderTime = LocalDateTime.now();
    private LocalDateTime orderDate = LocalDateTime.now();

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

    public double calculateTotal() {
        return 0;
    }


}
