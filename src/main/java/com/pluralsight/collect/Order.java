package com.pluralsight.collect;

import com.pluralsight.enums.SandwichSize;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private ArrayList<Product> sandwiches = new ArrayList<>();
    private ArrayList<Product> drinks = new ArrayList<>();
    private ArrayList<Product> chips = new ArrayList<>();
    private LocalDateTime orderTime;

    public Order() {
       this.orderTime = LocalDateTime.now();
    }

    public void addSandwich(Product product){
        sandwiches.add(product);
    }

    public void addDrink(Product product) {
        drinks.add(product);
    }

    public void addChips(Product product) {
        chips.add(product);
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
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

    public void completeOrder() {
        ReceiptManager receiptManager = new ReceiptManager(this);

        receiptManager.saveReceipt();
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
        if(!isValid()) {
            System.err.println("You must buy a chips or a drink to continue the purchase.");
        }
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

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("DELICIOUS SANDWICHES\n");
        sb.append("ORDER RECEIPT\n\n");

        sb.append("-------- SANDWICHES --------\n");
        for(Product s : sandwiches) {
            sb.append(s.toString()).append("\n\n");
        }

        sb.append("-------- DRINKS --------\n");
        for(Product d : drinks) {
            sb.append(d.toString()).append("\n\n");
        }

        sb.append("-------- CHIPS --------\n");
        for(Product c : chips) {
            sb.append(c.toString()).append("\n\n");
        }

        sb.append("\n TOTAL: $")
                .append(String.format("%.2f", calculateTotal()));

        return sb.toString();


    }

}
