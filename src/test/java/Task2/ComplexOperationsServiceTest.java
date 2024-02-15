package Task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class ComplexOperationsServiceTest {
    private final ComplexOperationsService service = new ComplexOperationsService();

    @ParameterizedTest
    @ValueSource(strings = {"Abcdefg1!", "P@ssw0rd$", "Qwerty12@", "1Hello_World!", "Strong#Pa55word"})
    void validatePasswordStrengthPositiveTest(String password) {
        Assertions.assertDoesNotThrow(() -> service.validatePasswordStrength(password));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Password123", "abcdefg1", "P@ss", "123456789", "StrongPassword"})
    void validatePasswordStrengthNegativeTest(String password) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.validatePasswordStrength(password));
    }

    @ParameterizedTest
    @ValueSource(strings = {"This is correct", "This text contains error", "fail is not good", "wrong way"})
    void processTextTest(String text) {
        if (text.contains("error") || text.contains("fail") || text.contains("wrong")) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> service.processText(text));
        } else {
            Assertions.assertDoesNotThrow(() -> service.processText(text));
        }
    }


    @ParameterizedTest
    @CsvSource({"'1,2,3,4', true",
            "'This text, 4 contains error', false",
            "'2,4,5,6,7,7,0', true",
            "'3,4,5,6,6,5', true"})
    void sumOfNumbersInStringTest(String text, boolean isValid) {
        if (!isValid) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> service.sumOfNumbersInString(text));
        } else {
            Assertions.assertDoesNotThrow(() -> service.sumOfNumbersInString(text));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"http://www.example.com/", "https://subdomain.example.org",
            "http://www.subdomain123.example.net", "ht//www.exampleuk"})
    void validateUrlFormatTest(String url) {
        String regex = "^(http|https)://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}.*$";
        if (url.matches(regex)) {
            Assertions.assertDoesNotThrow(() -> service.validateUrlFormat(url));
        } else {
            Assertions.assertThrows(IllegalArgumentException.class, () -> service.validateUrlFormat(url));
        }
    }

    private static Stream<List<String>> getEmailsTest() {
        return Stream.of(
                Arrays.asList("example@email.com", "user123@example.co.uk"),
                Arrays.asList("john.doe123@example.net", "my_email123example.org"),
                Arrays.asList("bob_jones@example.edu", "user@example.co"),
                Arrays.asList("test.com", "my_email123@example"));
    }

    @ParameterizedTest
    @MethodSource("getEmailsTest")
    void checkEmailListConsistencyTest(List<String> email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        if (email.stream().allMatch(s -> s.matches(regex))) {
            Assertions.assertDoesNotThrow(() -> service.checkEmailListConsistency(email));
        } else {
            Assertions.assertThrows(IllegalArgumentException.class, () -> service.checkEmailListConsistency(email));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"Paap", "maa m", "alex"})
    void checkStringPalindromeTest(String s) {
        String reversed = new StringBuilder(s.replaceAll("\\s+", "").toLowerCase()).reverse().toString();
        if (reversed.equals(s.replaceAll("\\s+", "").toLowerCase())) {
            Assertions.assertDoesNotThrow(() -> service.checkStringPalindrome(s));
        } else {
            Assertions.assertThrows(IllegalArgumentException.class, () -> service.checkStringPalindrome(s));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"Ab123456", "Cd987654", "Ef456789", "Gh987654", "Ij123456"})
    void validateIdentificationNumberPositiveTest(String id) {
        Assertions.assertDoesNotThrow(() -> service.validateIdentificationNumber(id));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Ab12345", "Cde123456", "1b234567", "ABc123456", "XY98765"})
    void validateIdentificationNumberNegativeTest(String id) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.validateIdentificationNumber(id));
    }

    private static Stream<Arguments> getNumbersAndThresholdPositiveTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 6, 4), 9),
                Arguments.of(Arrays.asList(1, 2, 6, 4, 5), 10),
                Arguments.of(Arrays.asList(1, 2, 6), 8),
                Arguments.of(Arrays.asList(1, 2, 6, 4, 9), 21)
        );
    }

    private static Stream<Arguments> getNumbersAndThresholdNegativeTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 6, 4), 13),
                Arguments.of(Arrays.asList(1, 2, 6, 4, 5), 25),
                Arguments.of(Arrays.asList(1, 2, 6), 9),
                Arguments.of(Arrays.asList(1, 2, 6, 4, 9), 30)
        );
    }

    @ParameterizedTest
    @MethodSource("getNumbersAndThresholdPositiveTest")
    void checkSumOfListAgainstThresholdPositiveTest(List<Integer> numbers, int threshold) {
        Assertions.assertDoesNotThrow(() -> service.checkSumOfListAgainstThreshold(numbers, threshold));
    }

    @ParameterizedTest
    @MethodSource("getNumbersAndThresholdNegativeTest")
    void checkSumOfListAgainstThresholdNegativeTest(List<Integer> numbers, int threshold) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.checkSumOfListAgainstThreshold(numbers,
                threshold));
    }

    @ParameterizedTest
    @ValueSource(strings = {"192.168.0.1", "10.20.30.40", "172.16.254.1", "255.255.255.0"})
    void validateIPAddressPositiveTest(String ipAddress) {
        Assertions.assertDoesNotThrow(() -> service.validateIPAddress(ipAddress));
    }

    @ParameterizedTest
    @ValueSource(strings = {"256.168.0.1", "10.20.30", "192.168.0.0.1", "300.400.500.600"})
    void validateIPAddressNegativeTest(String ipAddress) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.validateIPAddress(ipAddress));
    }

    private static Stream<List<String>> getTestPositiveEntries() {
        return Stream.of(
                Arrays.asList("apple", "banana", "orange", "kiwi", "grape", "pineapple"),
                Arrays.asList("banana", "kiwi", "orange", "apple", "pineapple", "grape"),
                Arrays.asList("orange", "kiwi", "banana", "grape", "apple", "pineapple"),
                Arrays.asList("grape", "orange", "kiwi", "pineapple", "banana", "apple", "mango", "pear")
        );
    }

    private static Stream<List<String>> getTestNegativeEntries() {
        return Stream.of(
                Arrays.asList("apple", "banana", "orange", "kiwi", "grape", "pineapple", "banana"),
                Arrays.asList("banana", "kiwi", "orange", "apple", "banana", "grape"),
                Arrays.asList("orange", "kiwi", "banana", "grape", "apple", "pineapple", "kiwi"),
                Arrays.asList("grape", "orange", "kiwi", "pineapple", "banana", "apple", "banana")
        );
    }

    @ParameterizedTest
    @MethodSource("getTestPositiveEntries")
    void ensureNoDuplicateEntriesPositiveTest(List<String> entries) {
        Assertions.assertDoesNotThrow(() -> service.ensureNoDuplicateEntries(entries));
    }

    @ParameterizedTest
    @MethodSource("getTestNegativeEntries")
    void ensureNoDuplicateEntriesNegativeTest(List<String> entries) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.ensureNoDuplicateEntries(entries));
    }
}