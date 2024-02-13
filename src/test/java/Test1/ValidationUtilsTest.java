package Test1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilsTest {
    ValidationUtils validationUtils = new ValidationUtils();
    @ParameterizedTest
    @ValueSource(strings = {"+1.txt123456789","+1.txt987654321","+1.txt555555555","+1.txt999888777"})
    void isPhoneNumberValidTrueTest(String number) {
        Assertions.assertTrue(validationUtils.isPhoneNumberValid(number));
    }
    @ParameterizedTest
    @ValueSource(strings = {"1234567890","+1.txt12345","+1.txt123456789012345","+4915204562218"})
    void isPhoneNumberValidFalseTest(String number) {
        Assertions.assertFalse(validationUtils.isPhoneNumberValid(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Password123!","SecurePass!1","Str0ng#P a55","P@ssw0rd789"})
    void isPasswordValidTrueTest(String password) {
        Assertions.assertTrue(validationUtils.isPasswordValid(password));
    }
    @ParameterizedTest
    @ValueSource(strings = {"password","P@ss","Passw0rd","p@ssword123"})
    void isPasswordValidFalseTest(String password) {
        Assertions.assertFalse(validationUtils.isPasswordValid(password));
    }
}