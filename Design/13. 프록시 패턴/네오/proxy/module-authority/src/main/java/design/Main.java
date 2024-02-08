package design;

import design.controller.MemberInfoController;
import design.model.Member;
import design.model.SimpleMember;
import design.model.Role;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        // me
        Member me = new SimpleMember("ME", Role.STAFF);

        // fetch data from data source
        List<Member> members = List.of(
                new SimpleMember("NEO", Role.DIRECTOR),
                new SimpleMember("상혁", Role.MANAGER),
                new SimpleMember("은선", Role.MANAGER),
                new SimpleMember("현철", Role.STAFF),
                new SimpleMember("수연", Role.STAFF)
        );

        MemberInfoController controller = new MemberInfoController(me);

        controller.printAll(members);
    }

}
