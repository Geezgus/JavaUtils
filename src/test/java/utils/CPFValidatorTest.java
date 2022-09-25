package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CPFValidatorTest {
    @Test
    void CPFValidationShouldSucceed() {
        Assertions.assertTrue(CPFValidator.validate("623.925.483-58"));
        Assertions.assertTrue(CPFValidator.validate("490.203.050-00"));
        Assertions.assertTrue(CPFValidator.validate("696.827.393-49"));
        Assertions.assertTrue(CPFValidator.validate("529.982.247-25"));

        Assertions.assertTrue(CPFValidator.validate("483.044.210-70"));
        Assertions.assertTrue(CPFValidator.validate("479.029.390-48"));
        Assertions.assertTrue(CPFValidator.validate("293.412.840-74"));
        Assertions.assertTrue(CPFValidator.validate("627.105.750-00"));
        Assertions.assertTrue(CPFValidator.validate("285.530.740-64"));

        Assertions.assertTrue(CPFValidator.validate("529982247-25"));
        Assertions.assertTrue(CPFValidator.validate("623925483-58"));
        Assertions.assertTrue(CPFValidator.validate("696827393-49"));


        Assertions.assertTrue(CPFValidator.validate("52998224725"));
        Assertions.assertTrue(CPFValidator.validate("62392548358"));
        Assertions.assertTrue(CPFValidator.validate("69682739349"));

        Assertions.assertTrue(CPFValidator.validate("14195317002"));
        Assertions.assertTrue(CPFValidator.validate("66976106030"));
        Assertions.assertTrue(CPFValidator.validate("13430628024"));
        Assertions.assertTrue(CPFValidator.validate("07389275030"));
        Assertions.assertTrue(CPFValidator.validate("70248996037"));
        Assertions.assertTrue(CPFValidator.validate("61120108012"));
    }

    @Test
    void CPFValidationShouldFail() {
        Assertions.assertFalse(CPFValidator.validate("529982247-2"));

        Assertions.assertFalse(CPFValidator.validate("111.111.111-11"));
        Assertions.assertFalse(CPFValidator.validate("123.456.789-10"));

        Assertions.assertFalse(CPFValidator.validate("111111111-11"));
        Assertions.assertFalse(CPFValidator.validate("123456789-10"));

        Assertions.assertFalse(CPFValidator.validate("11111111111"));
        Assertions.assertFalse(CPFValidator.validate("12345678910"));

        Assertions.assertFalse(CPFValidator.validate("1111111111"));
        Assertions.assertFalse(CPFValidator.validate("1234567891"));

        Assertions.assertFalse(CPFValidator.validate("483.044.210-7"));
        Assertions.assertFalse(CPFValidator.validate("483.044.21-70"));
        Assertions.assertFalse(CPFValidator.validate("483.04.210-70"));
        Assertions.assertFalse(CPFValidator.validate("48.044.210-70"));

        Assertions.assertFalse(CPFValidator.validate("52998224-25"));

        Assertions.assertFalse(CPFValidator.validate("7024899603"));
    }
}
