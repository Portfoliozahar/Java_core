

import collaborator.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Олег Водянский", 7500, 23));
        employees.add(new Boss("Анна Знахова", 12000, 41));
        employees.add(new Employee("Игорь Кремин", 9000, 36));

        System.out.println("До повышения зарплаты:");
        for (Employee employee : employees
        ) {
            System.out.println(employee);
        }

       Boss.upSalary(employees.toArray(new Employee[0]), 1000);
        System.out.println("\nПосле повышения зарплаты:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

    }
}