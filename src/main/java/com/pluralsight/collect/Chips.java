package com.pluralsight.collect;

public class Chips implements Product{
    //The customer can have freedom to choose what kind of "chip type" according to the instructions, and all chips will be the same price.
    private String chipType;

    public Chips(String chipType) {
        this.chipType = chipType;
    }

    public String getChipType() {
        return chipType;
    }

    @Override
    public double calculatePrice(){
        return 1.50;
    }
}
