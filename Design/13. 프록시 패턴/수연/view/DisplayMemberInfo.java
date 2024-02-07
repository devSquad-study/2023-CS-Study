package view;

import dto.Member;

import java.util.List;

public class DisplayMemberInfo {
    Member viewer; // 조회하려는 자

    public DisplayMemberInfo(Member viewer) {
        this.viewer = viewer;
    }

    // Member 객체 리스트를 받아 직원들의 정보를 순회하여 조회
    public void printAllInfo(List<Member> members) {
        members.stream()
                .map(member-> member.getInfo(viewer))
                .forEach(System.out::println);
    }

}
