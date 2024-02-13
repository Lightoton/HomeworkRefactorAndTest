package Test1;

// Честно скажу сократить до 1 строки предложила идея, сам не догадался, но использовать 2 if нет смысла можно всё в
// одном проверить.
public class UserValidation {
    public boolean validateUsername(String username) {
        // Проверка на длину имени
        return username.length() >= 6 && (username.length() <= 20 && username.matches("^[a-zA-Z0-9]+$"));
//        // Проверка на наличие специальных символов
//        if (!username.matches("^[a-zA-Z0-9]+$")) {
//            return false;
//        }
//
    }

    public boolean validateEmail(String email) {
        // Проверка на длину email
//        if (email.length() < 6 || email.length() > 50 && !email.contains("@")) {
//            return false;
//        }
        return email.length() >= 6 && (email.length() <= 50 && email.contains("@"));
//        // Проверка на наличие символа '@'
//        if (!email.contains("@")) {
//            return false;
//        }
    }
}

