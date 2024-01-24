package component.part;

import component.Component;
import component.ComponentType;

import java.util.ArrayList;
import java.util.List;

public class Group implements Component {

    private final String name;
    private final List<Component> components;

    public Group(String name) {
        this.name = name;
        components = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    @Override
    public Component add(Component component) {
        components.add(component);
        return component;
    }

    @Override
    public Component remove(int index) {
        return components.remove(index);
    }

    @Override
    public void printInfo(int tab) {
        System.out.printf("%s%s\n", "\t".repeat(tab), name);
        if (components.isEmpty()) {
            System.out.printf("%s%s", "\t".repeat(tab + 1), "비어있습니다.");
        }
        components.forEach(component -> component.printInfo(tab + 1));
    }

    @Override
    public Component get(int index) {
        return components.get(index);
    }

    @Override
    public ComponentType getType() {
        return ComponentType.GROUP;
    }

}
