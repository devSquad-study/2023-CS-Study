package design.model;

public class SimpleMember implements Member {

    private String name;
    private Role role;

    public SimpleMember(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Role getRole() {
        return role;
    }

    @Override
    public String getInfo() {
        return String.format("name: %s, role: %s", name, role);
    }

    @Override
    public String toString() {
        return getInfo();
    }

}
