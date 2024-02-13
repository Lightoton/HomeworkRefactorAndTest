package Test1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Employee {
    private String firstName;
    private String lastName;
    
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    public String getInitials() {
        return firstName.charAt(0) + "." + lastName.charAt(0) + ".";
    }
    
    // Дублирование кода формирования email
    public String getEmail() {
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@company.com";
    }
    /*из-за того что в методе getFullName возвращает с пробелом пришлось заменить на точку,
    ну я так понимаю так и задумывалось
    */
    public String getEmailNew() {
        return getFullName().replaceFirst(" ", ".").toLowerCase() + "@company.com";
    }
}

