public class Employee extends OrganizationChartComponent {
    String name;
    String position;
    String description;

    public Employee(String name, String position, String description) {
        this.name = name;
        this.position = position;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void print() {

        System.out.println(" " + getName() + ", " + getPosition() + " -- " + getDescription());
    }

}
