package collaborator;


public class Boss extends Employee {


    public Boss(String name, int salary, int age) {
        super(name, salary, age);
    }

    public static void upSalary(Employee[] employees, int amount) {
        for (Employee employee : employees
        ) {
            if (!(employee instanceof Boss)) {
                employee.upSalary(amount);
            }
        }
    }

}