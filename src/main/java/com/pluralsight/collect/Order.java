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

        for(Product p : products) {
            sb.append(p.toString()).append("\n");
        }

//        sb.append("     -------- SANDWICHES --------\n");
//        double subtotal = 0;
//        for(Product s : sandwiches) {
//            sb.append(s.toString()).append("\n");
//            subtotal += s.calculatePrice();
//        }
//
//        sb.append("SUBTOTAL:  $").append(subtotal).append("\n");
//
//
//        if (!drinks.isEmpty()) {
//            sb.append("      -------- DRINKS --------\n");
//            for(Product d : drinks) {
//                sb.append(d.toString());
//            }
//        }
//
//        if (!chips.isEmpty()) {
//            sb.append("      -------- CHIPS --------\n");
//            for (Product c : chips) {
//                sb.append(c.toString()).append("\n");
//            }
//        }
        sb.append("--------------------------------------\n");
        sb.append("TOTAL:     $")
                .append(String.format("%.2f", calculateTotal()));

        return sb.toString();


    }

}
