package view;

import dto.Member;
import dto.ROLE;

import java.util.List;

public class DisplayMemberInfoProxy extends DisplayMemberInfo{

    public DisplayMemberInfoProxy(Member viewer) {
        super(viewer);
    }

    private boolean shouldDisplay(Member member) {
        if(this.viewer.getPosition() == ROLE.DIRECTOR) {
            return true;
        } else if (this.viewer.getPosition() == ROLE.MANAGER) {
            return member.getPosition() != ROLE.DIRECTOR;
        }else {
            return this.viewer.equals(member);
        }
    }

    @Override
    public void printAllInfo(List<Member> members) {
        members.stream()
                .filter(this::shouldDisplay)
                .map(member -> member.getInfo(member))
                .forEach(System.out::println);
    }
}
