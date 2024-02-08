package CompositePattern.company;

public class Employee extends CompanyComponent {
    private String position = "사원";

    public Employee(String name, String phone, String email) {
        super(name);
        this.phone = phone;
        this.email = email;
    }

    @Override
    public void display() {
        System.out.println("Name: " + name + ", Position: " + position + ", Phone: " + phone + ", Email: " + email);
    }
}