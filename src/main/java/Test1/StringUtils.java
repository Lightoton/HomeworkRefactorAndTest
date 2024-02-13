package Test1;

import java.util.stream.Collectors;

// Нарушение KISS:
// насколько я знаю toUpperCase стринга игнорирует пробелы и знаки и спецсимволы
public class StringUtils {
//    public static String toUpperCase(String input) {
//        // Сложная реализация для простой операции
//        // ...
//        return input.chars()
//                .mapToObj(Character::toString)
//                .map(s -> {
//                    // Добавляем дополнительную логику преобразования, например, пропуск знаков препинания
//                    if (s.equals(" ")) {
//                        return " ";
//                    } else {
//                        return s.toUpperCase();
//                    }
//                })
//                .collect(Collectors.joining());
//    }
    public static String toUpperCase(String input){
        return input.toUpperCase();
    }
}

