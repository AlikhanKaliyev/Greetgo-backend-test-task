package kz.greetgo.gyzjutqwqvwlzxcbzcfr.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberUtil {
    private static final String PHONE_NUMBER_REGEX = "^(\\+?7\\d{10}|8\\d{10})$";

    public static String transformPhoneNumber(String phoneNumber) {
        String cleanedPhoneNumber = phoneNumber.replace("+", "");

        if (cleanedPhoneNumber.startsWith("7")) {
            cleanedPhoneNumber = "8" + cleanedPhoneNumber.substring(1);
        }

        return cleanedPhoneNumber;
    }

    public static boolean isPhoneNumberValid(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static String validateAndTransformPhoneNumber(String phoneNumber) {
        if (isPhoneNumberValid(phoneNumber)) {
            phoneNumber = transformPhoneNumber(phoneNumber);
        }
        return phoneNumber;
    }
}
