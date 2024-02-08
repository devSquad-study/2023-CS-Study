package CompositePattern.company;

import java.util.ArrayList;
import java.util.List;

public class TeamLeader extends CompanyComponent {
    private String position = "팀장";
    private List<CompanyComponent> members = new ArrayList<>();

    public TeamLeader(String name, String phone, String email) {
        super(name);
        this.phone = phone;
        this.email = email;
    }

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