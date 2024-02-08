package CompositePattern.company;

import java.util.ArrayList;
import java.util.List;

public class Company extends CompanyComponent {
    private List<CompanyComponent> members = new ArrayList<>();

    public Company(String name) {
        super(name);
    }

    @Override
    public void addMember(CompanyComponent member) {
        members.add(member);
    }

    @Override
    public void display() {
        System.out.println("Company: " + name);
        for (CompanyComponent member : members) {
            member.display();
        }

    }
}