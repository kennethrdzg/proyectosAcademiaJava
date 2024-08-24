package functional_programming;

public class Employee {
    static int employees;
    String name;
    String title;
    int employeeId;
    double salary;

    public Employee(){
        employees += 1;
        this.employeeId = employees;
    }

    public Employee(String name, String title, double salary){
        employees += 1;

        this.name = name;
        this.title = title;
        this.salary = salary;
        this.employeeId = employees;
    }

    public void raiseSalary(double raise){
        this.salary += raise;
    }

    public void promote(String new_title){
        this.title = new_title;
    }

    @Override
    public String toString(){
        return "Employee [ ID: " + this.employeeId + ", " + this.title + " " + this.name + ", Salary: " + this.salary + " ] ";
    }
}