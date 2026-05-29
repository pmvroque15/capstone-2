package com.pluralsight.collect;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    private final ArrayList<Product> products = new ArrayList<>();
    private final LocalDateTime orderTime;
    private double tipsAmount = 0;
    private static final double TAX_RATE_NYC = 0.08875;

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

    public void setTipsAmount(double tipsAmount) {
        this.tipsAmount = tipsAmount;
    }

    public double getTipsAmount() {
        return tipsAmount;
    }

    public double calculateTax(double subtotal) {

        return subtotal * TAX_RATE_NYC;
    }

    public Order checkOut() {
        ReceiptManager.saveReceipt(this);
        clearProducts();
        this.tipsAmount = 0;

        return new Order();
    }

    public void cancelOrder() {
        clearProducts();
        this.tipsAmount = 0;
    }


    public double subTotal() {

        double amount = 0;

        for (Product p : products) {
            if (p == null) {
                continue;
            }
            amount += p.calculatePrice();
        }

        return amount;
    }

    public double calculateTotal() {
        double tips = this.tipsAmount;
        return subTotal() + calculateTax(subTotal()) + tips;
    }



    @Override
    public String toString() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm");
        int orderNumber = (int) (Math.random() * 100);
        StringBuilder sb = new StringBuilder();
        sb.append("================ ORDER RECEIPT ===============\n");
        sb.append("           DELIcious Sandwiches 24/7 \n");
        sb.append("       \"Built Different. Stacked right.\"\n");
        sb.append("       123 Main street | (123) 456-3456   \n");
        sb.append("==============================================\n");
        sb.append(String.format("DATE: %-29s", getOrderTime().format(dateFormat)));
        sb.append(String.format("TIME: %s", getOrderTime().format(timeFormat)));
        sb.append("\n");
        sb.append(String.format("ORDER #%-23d", orderNumber)).append("CASHIER: MANAGER\n");
        sb.append("==============================================\n");
        for (Product p : products) {
            if (p instanceof BLTSandwich) {
                sb.append("BLT SANDWICH\n").append(p).append("\n");
            } else if (p instanceof PhillyCheeseSteak) {
                sb.append("PHILLY SANDWICH\n").append(p).append("\n");
            } else {
                sb.append(p).append("\n");

            }
        }
        sb.append("----------------------------------------------\n");
        sb.append(String.format("TIP:                                    $%.2f\n", this.tipsAmount));
        sb.append(String.format("SUBTOTAL:                               $%.2f\n", subTotal()));
        sb.append(String.format("TAX:                                    $%.2f\n", calculateTax(subTotal())));
        sb.append(String.format("TOTAL:                                  $%.2f\n", calculateTotal()));

        return sb.toString();
    }

}
