package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorsTest {
    @Test
    void validateCPF() {
        Assertions.assertTrue(Validators.validateCPF("883.135.759-05"));
    }
}
