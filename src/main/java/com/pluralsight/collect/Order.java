package com.pluralsight.collect;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private final ArrayList<Product> products = new ArrayList<>();
    private final LocalDateTime orderTime;
    private double amount;

    public Order() {
        this.orderTime = LocalDateTime.now();

    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public LocalDateTime getOrderTime() {
        return this.orderTime;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void clearProducts() {
        products.clear();
    }

    public void completeOrder(Order order) {
        ReceiptManager.saveReceipt(order);
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double addTax(double subtotal) {

        return subtotal * 0.008875;
    }

    public double subTotal() {

        double total = 0;

        if (amount != 0) {
            total += amount;
        }

        for (Product p : products) {
            if (p == null) {
                continue;
            }
            total += p.calculatePrice();
        }

        return total;
    }

    public double calculateTotal() {
        return subTotal() + addTax(subTotal());
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("================ ORDER RECEIPT ===============\n");
        sb.append("           DELIcious Sandwiches 24/7 \n");
        sb.append("       \"Built Different. Stacked right.\"\n");
        sb.append("       123 Main street | (123) 456-3456   \n");
        sb.append("==============================================\n");
        sb.append("ORDER NO.").append((int) (Math.random() * 100)).append("\n\n");
        for (Product p : products) {
            if (p instanceof Sandwich sandwich) {
                sb.append(sandwich);
            }
            if (p instanceof RegularTopping regularTopping) {
                sb.append(regularTopping);
            }
            if (p instanceof Drink drink) {
                sb.append(drink).append("\n");
            }

            if (p instanceof Chips chips) {
                sb.append(chips).append("\n");
            }
        }
        sb.append("----------------------------------------------\n");
        sb.append(String.format("TIP:                                    $%.2f\n", getAmount()));
        sb.append(String.format("SUBTOTAL:                               $%.2f\n", subTotal()));
        sb.append(String.format("TAX:                                    $%.2f\n", addTax(subTotal())));
        sb.append(String.format("TOTAL:                                  $%.2f\n", calculateTotal()));


        return sb.toString();
    }

}
