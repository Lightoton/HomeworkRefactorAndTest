package Test1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

class DateUtilsTest {
    DateUtils utils = new DateUtils();

    static Date dateTest = new Date(System.currentTimeMillis());

    static List<SimpleDateFormat> formatList = Arrays.asList(
            new SimpleDateFormat("dd/MM/yyyy"),
            new SimpleDateFormat("HH:mm:ss"),
            new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
    );
    static SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
    static SimpleDateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
    static SimpleDateFormat dateFormat3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");



    @Test
    void formatDateForDisplayNewTest() {
        Assertions.assertEquals(dateFormat1.format(dateTest), utils.formatDateForDisplayNew(dateTest, dateFormat1));
        Assertions.assertEquals(dateFormat2.format(dateTest), utils.formatDateForDisplayNew(dateTest, dateFormat2));
        Assertions.assertEquals(dateFormat3.format(dateTest), utils.formatDateForDisplayNew(dateTest, dateFormat3));
    }
    public static Stream<Arguments> getDateAndFormatTest() {
        return Stream.of(
                Arguments.of(dateTest, formatList.get(0)),
                Arguments.of(dateTest, formatList.get(1)),
                Arguments.of(dateTest, formatList.get(2))
        );
    }
    @ParameterizedTest
    @MethodSource("getDateAndFormatTest")
    void formatDateForDisplayNewTest(Date date, SimpleDateFormat sdf) {
        Assertions.assertEquals(sdf.format(dateTest), utils.formatDateForDisplayNew(date, sdf));
    }
}// Решил сделать двумя способами.