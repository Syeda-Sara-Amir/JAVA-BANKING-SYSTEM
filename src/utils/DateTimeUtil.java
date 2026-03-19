package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    // Used when storing timestamps in Transaction, Customer objects
    // Example output: "2024-03-15 14:32:01"
    public static String getCurrentTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    // Used when displaying dates in menus and history
    // Example output: "15 Mar 2024"
    public static String formatDate(String timestamp) {
        LocalDateTime dateTime = LocalDateTime.parse(timestamp,
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return dateTime.format(formatter);
    }

    // Used specifically for printing receipts
    // Example output: "15-Mar-2024 02:32 PM"
    public static String formatForReceipt(String timestamp) {
        LocalDateTime dateTime = LocalDateTime.parse(timestamp,
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a");
        return dateTime.format(formatter);
    }
}
