package com.pluralsight.collect;

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
                                                0 - Cancel Order
            """;

    public static void mainMenuDisplay() {
        System.out.println(MAIN_MENU);
    }

    public static void orderMenuDisplay() {
        System.out.println(ORDER_MENU);
    }
}
