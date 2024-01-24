
public class Main {
    public static void main(String[] args) {

        EmployeeComponent boss = new Employee("나대표","대표","123","naboos");

        EmployeeComponent teamLeader1 = new Employee("김뻔뻔","팀장","123","naboos");
        EmployeeComponent teamLeader2 = new Employee("나나태","팀장","123","naboos");

        EmployeeComponent employee1 = new Employee("표사원","사원","123","naboos");
        EmployeeComponent employee2 = new Employee("남사원","사원","123","naboos");
        EmployeeComponent employee3 = new Employee("김사원","사원","123","naboos");
        EmployeeComponent employee4 = new Employee("이사원","사원","123","naboos");

        EmployeeComponent company = new Company("가스레이터",boss);
        EmployeeComponent team1 = new Company("마케팅",teamLeader1);
        EmployeeComponent team2 = new Company("기술 개발",teamLeader2);

        team1.add(employee1);
        team1.add(employee2);
        team2.add(employee3);
        team2.add(employee4);

        company.add(team1);
        company.add(team2);

        company.print();
        team1.print();
    }
}