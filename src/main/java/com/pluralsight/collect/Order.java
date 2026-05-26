package com.pluralsight.collect;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    //todo Product, Sandwich, and Order class need refactoring on organization of saving in arraylists.
    private final ArrayList<Product> products = new ArrayList<>();
    private final LocalDateTime orderTime;

    public Order() {
       this.orderTime = LocalDateTime.now();
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void cancelOrder() {
        products.clear();
    }

    public void completeOrder() {
        ReceiptManager receiptManager = new ReceiptManager(this);

        receiptManager.saveReceipt();
    }

    //this method makes sure that if the customer orders no sandwiches at all, they are REQUIRED to order chips or drinks
    public boolean isValid() {
        boolean hasSandwich = false;
        boolean hasDrink = false;
        boolean hasChips = false;

        for(Product p: products) {
            if(p instanceof Sandwich) {
               hasSandwich = true;
            } else if (p instanceof Drink) {
                hasDrink = true;
            } else if (p instanceof Chips) {
                hasChips = true;
            }
        }

        //if no sandwiches, MUST have drink or chips.
        if(!hasSandwich) {
            return hasDrink || hasChips;
        }

        return true;
    }

    public double calculateTotal() {
        double total = 0;

        for(Product p: products) {
            if(p == null) {
                continue;
            }
            total += p.calculatePrice();
        }

        return total;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("================ ORDER RECEIPT ===============\n");
        sb.append("             DELICIOUS SANDWICHES \n");
        sb.append("==============================================\n");
        for(Product p : products) {
            if(p instanceof  Sandwich sandwich) {
                sb.append("      ").append(sandwich).append("\n");
            }
            if(p instanceof RegularTopping regularTopping) {
                sb.append("   ").append(regularTopping).append("\n");
            }
            if(p instanceof Drink drink) {
                sb.append("    ").append(drink).append("\n");
            }

            if(p instanceof Chips chips) {
                sb.append("    ").append(chips).append("\n");

            }
        }
        sb.append("-----------------------------------------------\n");
        sb.append("TOTAL:     $")
                .append(String.format("%.2f", calculateTotal()));

        return sb.toString();


    }

}
