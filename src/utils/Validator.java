package utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Validator {

    public static boolean isValidCnic(String cnic) {
    if (cnic == null) return false;
    return cnic.matches("\\d{5}-\\d{7}-\\d{1}");
}

public static boolean isValidPhone(String phone) {
    if (phone == null) return false;
    return phone.matches("\\d{11}");
}

public static boolean isValidEmail(String email) {
    if (email == null) return false;
    int atIndex = email.indexOf('@');
    if (atIndex < 1) return false;
    String afterAt = email.substring(atIndex + 1);
    return afterAt.contains(".");
}

public static boolean isValidAge(String dateOfBirth) {
    if (dateOfBirth == null) return false;
    try {
        LocalDate dob = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate today = LocalDate.now();
        return Period.between(dob, today).getYears() >= 18;
    } catch (DateTimeParseException e) {
        return false;
    }
}

public static boolean isValidAmount(double amount) {
    return amount > 0;
}
}
