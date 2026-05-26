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

    public void addProduct(Product product){
        products.add(product);
    }

    public LocalDateTime getOrderTime() {
        return this.orderTime;
    }

    public ArrayList<Product> getProducts(){
        return products;
    }

    public void clearProducts() {
        products.clear();
    }

    public void completeOrder() {
        ReceiptManager receiptManager = new ReceiptManager(this);

       receiptManager.saveReceipt();
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

        if(amount != 0) {
            total += amount;
        }

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
        sb.append("           DELIcious Sandwiches 24/7 \n");
        sb.append("       \"Built Different. Stacked right.\"\n");
        sb.append("       123 Main street | (123) 456-3456   \n");
        sb.append("==============================================\n");
        //todo maybe add a random orderNumber here
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
        //todo make a prompt for the tip and add it to the total
        sb.append(String.format("TIP:                                      $%.2f\n", getAmount()));
        sb.append(String.format("TOTAL:                                    $%.2f\n", calculateTotal()));

        return sb.toString();
    }

}
