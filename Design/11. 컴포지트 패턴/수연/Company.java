import java.util.ArrayList;
import java.util.List;

public class Company extends EmployeeComponent{

    List<EmployeeComponent> employees = new ArrayList<>();
    String teamName;

    EmployeeComponent delegate;

    public Company(String name, EmployeeComponent delegate){
        this.teamName = name;
        this.delegate = delegate;
    }

    @Override
    public void add(EmployeeComponent employeeComponent) {
        employees.add(employeeComponent);
    }

    @Override
    public void remove(EmployeeComponent employeeComponent) {
        employees.add(employeeComponent);
    }

    @Override
    public EmployeeComponent getChild(int i) {
        return employees.get(i);
    }

    @Override
    public String getName() {
        return teamName;
    }

    @Override
    public void print() {
        System.out.println();
        delegate.print();
        System.out.println();
        System.out.println(teamName);
        System.out.println("------------------");

        for (EmployeeComponent employee : employees) {
            employee.print();
        }

    }
}
