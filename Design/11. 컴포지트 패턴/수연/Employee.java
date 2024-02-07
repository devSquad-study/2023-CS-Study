public class Employee extends EmployeeComponent{
    String name;
    String grade;
    String phoneNumber;
    String email;

    public Employee(String name, String grade, String phoneNumber, String email ){
        this.name = name;
        this.grade = grade;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGrade() {
        return grade;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void print() {
        System.out.println("이름 : " + getName());
        System.out.println("직급 : " + getGrade());
        System.out.println("전화번호 : " + getPhoneNumber());
        System.out.println("이메일 : " + getEmail());
        System.out.println();
    }
}
