package com.pluralsight.collect;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    //todo change from three arraylists to one
    private final ArrayList<Product> products = new ArrayList<>();
    private LocalDateTime orderTime;

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
        return !products.isEmpty();
    }

    public double calculateTotal() {
        double total = 0;
        //adding isValid(), to make sure that the customer will buy chips or drink
        if(!isValid()) {
            throw new IllegalStateException("You must buy chips or drinks.");
        }

        for(Product p: products) {
            total += p.calculatePrice();
        }

        return total;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("========= UNOFFICIAL RECEIPT =========\n");
        for(Product p : products) {
            if(p instanceof RegularTopping regularTopping) {
                sb.append(regularTopping).append("\n");
            }
            if(p instanceof Drink drink) {
                sb.append("--------------------------------------\n");
                sb.append(drink).append("\n");
            }

            if(p instanceof Chips chips) {
                sb.append("--------------------------------------\n");
                sb.append(chips).append("\n");

            }
        }
        sb.append("--------------------------------------\n");
        sb.append("TOTAL:     $")
                .append(String.format("%.2f", calculateTotal()));

        return sb.toString();


    }

}
