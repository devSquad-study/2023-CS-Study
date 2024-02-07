package dto;

// 구성원 클래스
public class Member {
    private String name; // 이름
    private ROLE position; // 직위

    public Member(String name, ROLE position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public ROLE getPosition() {
        return position;
    }

    public String getInfo(Member viewer) {
        return "Display " + getPosition().name() + " '" + getName() + "' personnel information.";
    }
}
