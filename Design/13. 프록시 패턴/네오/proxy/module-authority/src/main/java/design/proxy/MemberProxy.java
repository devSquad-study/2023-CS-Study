package design.proxy;

import design.model.Member;
import design.model.Role;

public class MemberProxy implements Member {

    private final Member target;
    private final boolean access;

    public MemberProxy(Member target, Member me) {
        this.target = target;
        this.access = me.getRole() == target.getRole();
    }

    @Override
    public String getName() {
        if (access) {
            return target.getName();
        }
        throw new IllegalStateException("권한이 없습니다.");
    }

    @Override
    public Role getRole() {
        if (access) {
            return target.getRole();
        }
        throw new IllegalStateException("권한이 없습니다.");
    }

    @Override
    public String getInfo() {
        if (access) {
            return target.getInfo();
        }
        throw new IllegalStateException("권한이 없습니다.");
    }

    @Override
    public String toString() {
        return getInfo();
    }

}
