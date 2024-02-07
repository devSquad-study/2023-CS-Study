package design.controller;

import design.model.Member;
import design.proxy.MemberProxy;

import java.util.Collection;

public class MemberInfoController {

    private final Member me;

    public MemberInfoController(Member me) {
        this.me = me;
    }

    public void printAll(Collection<Member> members) {
        members.forEach(member -> {
            try {
                System.out.println(new MemberProxy(member, me));
            } catch (IllegalStateException exception) {
                System.err.println(exception.getMessage());
            }
        });
    }

}
