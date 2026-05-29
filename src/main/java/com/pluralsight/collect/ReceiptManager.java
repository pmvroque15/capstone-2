package com.pluralsight.collect;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class  ReceiptManager {
    private static final String DIRECTORY_PATH = "src/main/resources/receipts/";
    private static final String EXTENSION_FILE = ".txt";

    public static void saveReceipt(Order order) {
        LocalDateTime orderTime = order.getOrderTime();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String filename = DIRECTORY_PATH + orderTime.format(dateTimeFormatter) + EXTENSION_FILE;

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));

            bufferedWriter.write(order.toString());

            bufferedWriter.close();
        }

        catch (IOException e) {
            System.err.println("I/O error while saving receipt");
        }
    }
}
