package com.pluralsight.collect;

import java.security.Signature;

public class MenuStrings {
    private static final String MAIN_MENU = """
            
                                               DELIcious Sandwiches
                                        "Built Different. Stacked right."
                                        --------------------------------
                                                Select an option:
                                                1 - New Order
                                                0 - Exit
            """;

    private static final String ORDER_MENU = """
                                                   Order Screen
                                        --------------------------------
                                                Select an option:
                                                1 - Add Sandwich
                                                2 - Add Drink
                                                3 - Add Chips
                                                4 - Checkout
                                                5 - Signature Sandwiches
                                                0 - Cancel Order
            """;
    private static final String SIGNATURE_SANDWICHES = """   
                                              Signature Sandwiches
                                        --------------------------------
                                                Select an option:
                                              "BLT" - BLT sandwich
                                           "Philly" - Philly Cheese Steak
                                              "0"   - go back to the menu
            """;

    public static void mainMenuDisplay() {
        System.out.println(MAIN_MENU);
    }

    public static void orderMenuDisplay() {
        System.out.println(ORDER_MENU);
    }

    public static void signaturesSandwichesDisplay() {
        System.out.println(SIGNATURE_SANDWICHES);
    }
}
