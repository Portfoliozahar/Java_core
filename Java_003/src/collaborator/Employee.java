package collaborator;
public class Employee {

    private String name;
    private int salary;
    private int age;

    public Employee(String name, int salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }


    public void upSalary(int amount) {
        salary += amount;
    }


    @Override
    public String toString() {
        return "Сотрундик " + name  + ",зарплата " + salary + " возраст " + age ;
    }
}