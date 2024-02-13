package Test1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EmployeeTest {
    Employee employee = new Employee("Vasia", "Pupkin");
    String firstName = employee.getFirstName();
    String lastName = employee.getLastName();

    @Test
    void getFullName() {
        Assertions.assertEquals(firstName + " " + lastName, employee.getFullName());
    }

    @Test
    void getInitials() {
        Assertions.assertEquals(firstName.charAt(0) + "." + lastName.charAt(0) + ".", employee.getInitials());
    }

    @Test
    void getEmailNew() {
        Assertions.assertEquals(firstName.toLowerCase() + "." + lastName.toLowerCase() + "@company.com",
                employee.getEmailNew());
    }
}