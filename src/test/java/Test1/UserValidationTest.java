package Test1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UserValidationTest {
    UserValidation userValidation = new UserValidation();
    @ParameterizedTest
    @ValueSource(strings = {"Lightoton","ElectricJaguar","MysticPhoenix","MidnightShadow","SolarSpecter"})
    void validateUsernameTrueTest(String s) {
        Assertions.assertTrue(userValidation.validateUsername(s));
    }
    @ParameterizedTest
    @ValueSource(strings = {"hi!","Ghost&","MyUsernameIsVeryLongIndeed","MidnightShadow!"})
    void validateUsernameFalseTest(String s) {
        Assertions.assertFalse(userValidation.validateUsername(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {"example1@example.com","user2@mail.com","test_email3@test.com","myaddress4@gmail.com"})
    void validateEmailTrueTest(String s) {
        Assertions.assertTrue(userValidation.validateEmail(s));
    }
    @ParameterizedTest
    @ValueSource(strings = {"user@","example.com","test@toolofshjvjdnghfkgjdbvjdbdjbcjdjdbfjfbdjjngemailaddress.com",
            "noatsign.com"})
    void validateEmailFalseTest(String s) {
        Assertions.assertFalse(userValidation.validateEmail(s));
    }
}