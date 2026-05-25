package com.pluralsight.collect;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {
    private Order order;
    private static final String DIRECTORY_PATH = "src/main/resources/receipts/";
    private static final String EXTENSION_FILE = ".txt";

    public ReceiptManager(Order order) {
        this.order = order;
    }


    public void saveReceipt() {
        LocalDateTime orderTime = order.getOrderTime();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String filename = DIRECTORY_PATH + orderTime.format(dateTimeFormatter) + EXTENSION_FILE;

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));

            bufferedWriter.write("================ ORDER RECEIPT ===============\n");
            bufferedWriter.write("             DELICIOUS SANDWICHES \n");
            bufferedWriter.write("==============================================\n");
            bufferedWriter.write(order.toString());

            bufferedWriter.close();
        }

        catch (IOException e) {
            System.err.println("I/O error while saving receipt");
        }
    }
}
