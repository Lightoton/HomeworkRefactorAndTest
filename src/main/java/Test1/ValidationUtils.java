package Test1;


public class ValidationUtils {
    //все проверки можно сделать в одной я так думаю
//    public boolean isEmailValid(String email) {
//        String emailRegex = "^[A-Za-z0-9+_.-]+@(?:[A-Za-z0-9-]+\\.)+[A-Za-z]{2,}$";
//        boolean b = checker(emailRegex);
//        return b;
//    }

    public boolean isPhoneNumberValid(String phoneNumber) {
        if (phoneNumber.startsWith("+1.txt")){ // Тут похоже неправильно указан "код" просто он же не может
            // содержать символы, но я вроде сделал так что теперь всё нормально. Так как следующая строка убирает
            // всё кроме цифр пришлось проверку вынести выше.
            String digitsOnly = phoneNumber.replaceAll("[^0-9]", "");
            // Проверка на допустимую длину номера (например, 10 цифр)
            return digitsOnly.length() == 10;
        }
        return false;

//        if (digitsOnly.length() != 10 && !digitsOnly.startsWith("+1.txt")) {
//            return false;
//        }
//        // Проверка кода страны (например, должен начинаться с +1.txt для США)
//        if (!digitsOnly.startsWith("+1.txt")) {
//            return false;
//        }
    }

    public boolean isPasswordValid(String password) {
        //решил ещё дополнить удаление пробелов на всякий
        String passwordRes = password.replaceAll(" ","");
        return passwordRes.length() >= 8 && passwordRes.matches(".*[A-Z].*") && passwordRes.matches(".*[a-z].*")
                && passwordRes.matches(".*\\d.*") && passwordRes.matches(".*[!@#$%].*") && !passwordRes.contains(" ");
//        if (password.length() < 8 || !password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*")
//                || !password.matches(".*\\d.*") || !password.matches(".*[!@#$%].*") || password.contains(" ")) {
//            return false;
//        }

//        // Пароль должен содержать хотя бы одну заглавную букву (A-Z)
//        if (!password.matches(".*[A-Z].*")) {
//            return false;
//        }

        // Пароль должен содержать хотя бы одну строчную букву (a-z)
//        if (!password.matches(".*[a-z].*")) {
//            return false;
//        }

        // Пароль должен содержать хотя бы одну цифру (0-9)
//        if (!password.matches(".*\\d.*")) {
//            return false;
//        }

        // Пароль должен содержать хотя бы один специальный символ (например, !, @, #, $, %)
//        if (!password.matches(".*[!@#$%].*")) {
//            return false;
//        }

        // Пароль не должен содержать пробелов
//        if (password.contains(" ")) {
//            return false;
//        }

        // Все правила выполнены
    }
}
