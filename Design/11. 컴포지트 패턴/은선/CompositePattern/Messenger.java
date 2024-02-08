package CompositePattern;

import CompositePattern.company.CompanyComponent;

public class Messenger {
    CompanyComponent company;

    public Messenger(CompanyComponent company) {
        this.company = company;
    }

    public void printCompany() {
        System.out.println("전체 기업의 구조도입니다.");
        company.display();
        System.out.println();
    }
    public void printEmployee(CompanyComponent employee) {
        System.out.println(employee.name + "님의 정보를 확인합니다.");

        employee.display();
        System.out.println();
    }
}
