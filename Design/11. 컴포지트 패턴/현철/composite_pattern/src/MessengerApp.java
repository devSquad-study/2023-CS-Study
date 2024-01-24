public class MessengerApp {
    OrganizationChartComponent chartComponent;

    public MessengerApp(OrganizationChartComponent chartComponent) {
        this.chartComponent = chartComponent;
    }

    public void printChart() {
        chartComponent.print();
    }
}
