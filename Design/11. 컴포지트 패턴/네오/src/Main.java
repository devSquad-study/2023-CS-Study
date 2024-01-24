import component.Component;
import component.part.Group;
import component.people.Level;
import component.people.Worker;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Component hq = new Group("본사");
        hq.add(new Worker(Level.BOSS, "김대표"));

        Component managementTeam = hq.add(new Group("경영지원팀"));
        managementTeam.add(new Worker(Level.TEAM_MANAGER, "김팀장"));
        managementTeam.add(new Worker(Level.STAFF, "김물컹"));
        managementTeam.add(new Worker(Level.STAFF, "김똑똑"));

        Component devTeam = hq.add(new Group("개발본부"));
        devTeam.add(new Worker(Level.HEAD_QUARTER_DIRECTOR, "개발 본부장"));

        Component dev01 = devTeam.add(new Group("ㅇㅇㅇ서비스팀"));
        dev01.add(new Worker(Level.TEAM_MANAGER, "이팀장"));
        dev01.add(new Worker(Level.STAFF, "이말캉"));
        dev01.add(new Worker(Level.STAFF, "이단단"));

        devTeam.add(new Group("ㅁㅁㅁ서비스팀"));

        hq.printInfo(0);
    }
}