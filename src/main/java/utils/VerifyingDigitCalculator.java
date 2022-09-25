package utils;

import java.util.regex.Pattern;

public class VerifyingDigitCalculator {

    public static int calcMod11(String number) {
        if (!Pattern.matches("^[0-9]+$", number)) {
            throw new IllegalArgumentException("Argument is not decimal number");
        }

        int sum = 0;
        for (int i = 0, j = number.length(); i < number.length() - 1; i++, j--) {
            final int digit = Character.getNumericValue(
                number.charAt(i)
            );

            sum += digit * j;
        }

        return (sum * 10) % 11;
    }
}
