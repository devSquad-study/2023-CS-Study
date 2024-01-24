public class Main {
    public static void main(String[] args) {
        OrganizationChartComponent CEO = new Organization("대표", "대표 소속");

        OrganizationChartComponent developmentHeadquarters = new Organization("개발 본부", "개발 부서 디렉터 소속");
        OrganizationChartComponent personnelHeadquarters = new Organization("인사 본부", "인사 부서 디렉터 소속");

        OrganizationChartComponent developmentDepartment = new Organization("개발 부서", "사원 및 팀장 소속");
        OrganizationChartComponent personnelDepartment = new Organization("인사 부서", "사원 및 팀장 소속");

        CEO.add(new Employee("박대표", "대표", "발로하는개발 대표"));

        CEO.add(developmentHeadquarters);
        CEO.add(personnelHeadquarters);

        developmentHeadquarters.add(new Employee("이디렉터", "디렉터", "개발 부서 관리, 팀장 조직"));
        personnelHeadquarters.add(new Employee("서디렉터", "디렉터","인사 부서 관리, 팀장 조직"));

        developmentHeadquarters.add(developmentDepartment);

        developmentDepartment.add(new Employee("박개발", "팀장", "개발 부서 팀장"));
        developmentDepartment.add(new Employee("김개발", "사원", "개발 부서 사원"));
        developmentDepartment.add(new Employee("윤개발", "사원", "개발 부서 사원"));

        personnelHeadquarters.add(personnelDepartment);

        personnelDepartment.add(new Employee("서인사", "팀장", "인사 부서 팀장"));
        personnelDepartment.add(new Employee("박인사", "사원", "인사 부서 사원"));
        personnelDepartment.add(new Employee("이인사", "사원", "인사 부서 사원"));

        MessengerApp messengerApp = new MessengerApp(CEO);

        messengerApp.printChart();
    }
}
