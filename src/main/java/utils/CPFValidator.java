package utils;

import java.util.Arrays;

public class CPFValidator {
    private static final FormatValidator validator = new FormatValidator();

    public static boolean validate(String cpf) {
        boolean isProperlyFormatted = validator.testAgainstAny(
            cpf, Arrays.asList("000.000.000-00", "000000000-00", "00000000000")
        );

        if (!isProperlyFormatted) {
            return false;
        }

        String cpfNumbers = cpf.replaceAll("\\.", "").replaceAll("-", "");

        if (!isDigitSequenceValid(cpfNumbers)) {
            return false;
        }

        return (firstDigitIsValid(cpfNumbers) && secondDigitIsValid(cpfNumbers));
    }

    private static boolean isDigitSequenceValid(String number) {
        char c = number.charAt(0);
        for (int i = 0; i < number.length() - 1; i++) {
            if (c != number.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    private static boolean firstDigitIsValid(String numbers) {
        int mod11 = VerifyingDigitCalculator.calcMod11(numbers.substring(0, 10));
        int result = mod11 == 10 ? 0 : mod11;
        return result == Integer.parseInt(numbers.substring(9, 10));
    }

    private static boolean secondDigitIsValid(String numbers) {
        int mod11 = VerifyingDigitCalculator.calcMod11(numbers);
        int result = mod11 == 10 ? 0 : mod11;
        return result == Integer.parseInt(numbers.substring(10));
    }
}