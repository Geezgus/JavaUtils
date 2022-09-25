package utils;

public class Validators {
    static boolean validateCPF(String cpf) {
        return CPFValidator.validate(cpf);
    }
}
