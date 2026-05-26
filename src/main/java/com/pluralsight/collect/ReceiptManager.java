package com.pluralsight.collect;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {
    private File currentReceiptFile;
    private final Order order;
    private static final String DIRECTORY_PATH = "src/main/resources/receipts/";
    private static final String EXTENSION_FILE = ".txt";
    private static String filename = "";
    public ReceiptManager(Order order) {
        this.order = order;
    }

    public void saveReceipt() {
        LocalDateTime orderTime = order.getOrderTime();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        filename = DIRECTORY_PATH + orderTime.format(dateTimeFormatter) + EXTENSION_FILE;

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));

            bufferedWriter.write(order.toString());

            bufferedWriter.close();
        }

        catch (IOException e) {
            System.err.println("I/O error while saving receipt");
        }
    }

    public void deleteCurrentReceipt() {

        if(currentReceiptFile != null && currentReceiptFile.exists()) {

            boolean wasDeleted = currentReceiptFile.delete();

            if(wasDeleted) {
                System.out.println("Receipt deleted.");
            }
        }
    }
}
