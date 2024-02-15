package org.example.TESTING._2024_02_15;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ComplexOperationsServiceTest {

    private final ComplexOperationsService service = new ComplexOperationsService();

    @ParameterizedTest
    @CsvSource({
            "weak, false",
            "strongPassword1@, true",
            "noDigit!, false",
            "NoSpecialChar1, false"
    })
    void validatePasswordStrength(String password, boolean isValid) {
        if (!isValid) {
            assertThrows(IllegalArgumentException.class, () -> service.validatePasswordStrength(password));
        } else {
            // Assume no exception for valid passwords
            // This is a placeholder for actual validation logic if method returns a value or has other effects
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"This is correct", "This text contains error", "fail is not good", "wrong way"})
    void processText(String text) {
        if (text.contains("error") || text.contains("fail") || text.contains("wrong")) {
            assertThrows(IllegalArgumentException.class, () -> service.processText(text));
        } else {
            // Assume no exception for valid texts
        }
    }

}


// For checkEmailListConsistency and other methods requiring complex inputs or multiple parameters,
// you might use @MethodSource to supply a Stream of arguments.
// Example setup for @MethodSource (not fully implemented due to complexity):
// public static Stream<Arguments> emailListProvider() {
//     return Stream.of(
//         Arguments.of(Arrays.asList("valid@email.com", "invalid-email"), false),
//         Arguments.of(Arrays.asList("valid@email.com", "also.valid@email.com"), true)
//     );
// }

// Example test method using @MethodSource for email lists
// @ParameterizedTest
// @MethodSource("emailListProvider")
// void checkEmailListConsistency(List<String> emails, boolean isValid) {
//     if (!isValid) {
//         assertThrows(IllegalArgumentException.class, () -> service.checkEmailListConsistency(emails));
//     } else {
//         // Assume no exception for valid email lists
//     }
// }

// Continue writing tests for the remaining methods follo
