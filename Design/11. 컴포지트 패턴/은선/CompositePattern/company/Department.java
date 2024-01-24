package CompositePattern.company;

import java.util.ArrayList;
import java.util.List;

public class Department extends CompanyComponent {
    private List<CompanyComponent> members = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void addMember(CompanyComponent member) {
        members.add(member);
    }

    @Override
    public void display() {
        System.out.println("Department: " + name);
        for (CompanyComponent member : members) {
            member.display();
        }
    }
}