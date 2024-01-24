package CompositePattern.company;

import java.util.ArrayList;
import java.util.List;

public class DevisionDirector extends CompanyComponent {
    private String position = "본부장";

    private List<CompanyComponent> members = new ArrayList<>();

    public DevisionDirector(String name, String phone, String email) {
        super(name);
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public void addMember(CompanyComponent member) {
        members.add(member);
    }

    @Override
    public void display() {
        System.out.println("Name: " + name + ", Position: " + position + ", Phone: " + phone + ", Email: " + email);
        for (CompanyComponent member : members) {
            member.display();
        }
    }
}