import dto.Member;
import dto.ROLE;
import view.DisplayMemberInfo;
import view.DisplayMemberInfoProxy;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 직원별 개인 객체 생성
        Member CTO = new Member ("NEO", ROLE.DIRECTOR);
        Member devManager = new Member ("상혁", ROLE.MANAGER);
        Member financeManager = new Member ("은선", ROLE.MANAGER);
        Member devStaff = new Member ("현철", ROLE.STAFF);
        Member financeStaff = new Member ("수연", ROLE.STAFF);

        // 사람들을 리스트로 가공
        List<Member> members = Arrays.asList(CTO, devManager, financeManager, devStaff, financeStaff);

        // 나 : 일개 멤버 직책
        Member me = new Member("ME", ROLE.STAFF);

        System.out.println("\n================================================================");
        System.out.println("일개 멤버인 내가 회사에선 열람 최강자..?");
        System.out.println("================================================================");
        DisplayMemberInfo view = new DisplayMemberInfoProxy(financeManager); // 모든 사람들 정보를 출력하는 클래스
        view.printAllInfo(members); // 일개 멤버에 불구하고 모든 사람들 조회
    }
}