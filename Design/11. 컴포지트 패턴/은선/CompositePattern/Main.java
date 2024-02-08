package CompositePattern;

import CompositePattern.company.*;

public class Main {
    public static void main(String[] args) {
        // 기업 조직 구조 생성
        Company company = new Company("Eunsun Corp");

        CEO ceo = new CEO("김대표", "010-1234-5678", "kim@eunsun.com");
        DevisionDirector devisionDirector = new DevisionDirector("박본부장", "010-5678-1234", "park@eunsun.com");

        TeamLeader teamLeader1 = new TeamLeader("윤팀장", "010-8765-4321", "yoon@eunsun.com");
        TeamLeader teamLeader2 = new TeamLeader("이팀장", "010-4321-9876", "lee@eunsun.com");

        Employee employee1 = new Employee("고사원", "010-1111-2222", "go@eunsun.com");
        Employee employee2 = new Employee("민사원", "010-3333-4444", "min@eunsun.com");
        Employee employee3 = new Employee("조사원", "010-5555-6666", "cho@eunsun.com");


        // 회사 - 대표, 본부
        company.addMember(ceo);
        ceo.addMember(devisionDirector);
        devisionDirector.addMember(teamLeader1);
        devisionDirector.addMember(teamLeader2);
        teamLeader1.addMember(employee1);
        teamLeader1.addMember(employee2);
        teamLeader2.addMember(employee3);

        // Messenger
        Messenger messenger = new Messenger(company);
        messenger.printCompany();
        messenger.printEmployee(employee1);
        messenger.printEmployee(devisionDirector);

//        Department productDevelopmentDivision = new Department("제품개발 본부");
//        Department developTeam = new Department("개발 팀");
//        Department designTeam = new Department("디자인 팀");


//        // 회사 - 대표, 본부
//        company.addMember(ceo);
//        company.addMember(productDevelopmentDivision);
//
//        // 본부 - 본부장, 팀
//        productDevelopmentDivision.addMember(devisionDirector);
//        productDevelopmentDivision.addMember(developTeam);
//        productDevelopmentDivision.addMember(designTeam);
//
//        // 팀 - 팀장, 사원
//        developTeam.addMember(teamLeader1);
//        developTeam.addMember(employee1);
//        developTeam.addMember(employee2);
//        teamLeader1.addMember(employee1);
//        teamLeader1.addMember(employee2);
//
//        designTeam.addMember(teamLeader2);
//        designTeam.addMember(employee3);
//        teamLeader2.addMember(employee3);
//
//
//        // 조직 구조 출력
//        company.display();
//        System.out.println();
//        employee3.display();
//        System.out.println();
//        teamLeader1.display();
//        System.out.println();
//        employee2.display();
//        System.out.println();
//        teamLeader2.display();
//        System.out.println();
//        productDevelopmentDivision.display();
//        System.out.println();
//        developTeam.display();
//        System.out.println();
//        devisionDirector.display();
//        System.out.println();
//        teamLeader1.display();
    }
}
