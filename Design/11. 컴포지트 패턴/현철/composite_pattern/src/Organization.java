import java.util.ArrayList;

public class Organization extends OrganizationChartComponent {
    ArrayList<OrganizationChartComponent> organizationChart = new ArrayList<>();
    String name;
    String description;

    public Organization(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(OrganizationChartComponent organizationChartComponent) {
        organizationChart.add(organizationChartComponent);
    }

    @Override
    public void remove(OrganizationChartComponent organizationChartComponent) {
        organizationChart.remove(organizationChartComponent);
    }

    @Override
    public OrganizationChartComponent getPeople(int i) {
        return organizationChart.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void print() {
        System.out.println(getName() + ", " + getDescription());

        for (OrganizationChartComponent chartComponent : organizationChart) {
            chartComponent.print();
        }
    }
}
