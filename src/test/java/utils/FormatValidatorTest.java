package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FormatValidatorTest {
    FormatValidator validator;

    @BeforeEach
    void setup() {
        validator = new FormatValidator();
    }

    @Test
    void testAgainst() {
        Assertions.assertTrue(validator.testAgainst("BRA2E19", "AAA0A00"));
        Assertions.assertTrue(validator.testAgainst("IRS-1836", "AAA-0000"));

        // License plate should fail
        Assertions.assertFalse(validator.testAgainst("BR2AE19", "AAA0A00"));
        Assertions.assertFalse(validator.testAgainst("IRS1836", "AAA-0000"));

        // CPF should pass
        Assertions.assertTrue(validator.testAgainst("089.786.910-99", "000.000.000-00"));
        Assertions.assertTrue(validator.testAgainst("639515630-60", "000000000-00"));
        Assertions.assertTrue(validator.testAgainst("26969301044", "00000000000"));

        // CPF should fail
        Assertions.assertFalse(validator.testAgainst("08A.786.910-99", "000.000.000-00"));
        Assertions.assertFalse(validator.testAgainst("63901563060", "000000000-00"));
        Assertions.assertFalse(validator.testAgainst("2696301044", "00000000000"));

        // RG should pass
        Assertions.assertTrue(validator.testAgainst("45.082.657-0", "00.000.000-0"));

        // RG should fail
        Assertions.assertFalse(validator.testAgainst("45.082.657-00", "00.000.000-0"));

        // Date should pass
        Assertions.assertTrue(validator.testAgainst("24/07/1971", "00/00/0000"));

        // Date should fail
        Assertions.assertFalse(validator.testAgainst("1971/07/24", "00/00/0000"));

        // Uppercase should pass
        Assertions.assertTrue(validator.testAgainst("ABC", "AAA"));
        Assertions.assertTrue(validator.testAgainst("A.B.C.", "A.A.A."));

        // Uppercase should fail
        Assertions.assertFalse(validator.testAgainst("123", "AAA"));
        Assertions.assertFalse(validator.testAgainst("abc", "AAA"));
        Assertions.assertFalse(validator.testAgainst("ABCD", "AAA"));
        Assertions.assertFalse(validator.testAgainst("AB", "AAA"));

        // Lowercase should pass
        Assertions.assertTrue(validator.testAgainst("abc", "aaa"));
        Assertions.assertTrue(validator.testAgainst("abc", "aaa"));

        // Lowercase should fail
        Assertions.assertFalse(validator.testAgainst("123", "aaa"));
        Assertions.assertFalse(validator.testAgainst("ABC", "aaa"));
        Assertions.assertFalse(validator.testAgainst("abcd", "aaa"));
        Assertions.assertFalse(validator.testAgainst("ab", "aaa"));

        // Any casing should pass
        Assertions.assertTrue(validator.testAgainst("abc", "CCC"));
        Assertions.assertTrue(validator.testAgainst("ABC", "CCC"));

        // Any casing should fail
        Assertions.assertFalse(validator.testAgainst("123", "CCC"));
        Assertions.assertFalse(validator.testAgainst("ABCD", "CCC"));
        Assertions.assertFalse(validator.testAgainst("AB", "CCC"));

        // Digits should pass
        Assertions.assertTrue(validator.testAgainst("1234", "0000"));

        // Digits should fail
        Assertions.assertFalse(validator.testAgainst("ABC", "000"));
        Assertions.assertFalse(validator.testAgainst("abc", "000"));
        Assertions.assertFalse(validator.testAgainst("1234", "000"));
        Assertions.assertFalse(validator.testAgainst("12", "000"));

        // Mixed characters should pass
        Assertions.assertTrue(validator.testAgainst("ABC1234", "AAA0000"));
        Assertions.assertTrue(validator.testAgainst("123.123.123-12", "000.000.000-00"));
    }

    @Test
    void testAgainstAny() {
        Assertions.assertTrue(validator.testAgainstAny(
            "BRA2E19", Arrays.asList("AAA-0000", "AAA0A00")
        ));
    }
}
