package component.people;

import component.Component;
import component.ComponentType;

import java.util.UUID;

public class Worker implements Component {

    private String id; // 사번
    private Level level; // 직급
    private String name; // 직원 이름

    public Worker(Level level, String name) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.level = level;
        this.name = name;
    }

    @Override
    public void printInfo(int tab) {
        System.out.printf("%s%s %s %s\n", "\t".repeat(tab), id, level, name);
    }

    @Override
    public ComponentType getType() {
        return ComponentType.WORKER;
    }

}
