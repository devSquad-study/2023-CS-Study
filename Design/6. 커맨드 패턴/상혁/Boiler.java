public class Boiler implements Device {

    @Override
    public void turnOn() {
        System.out.println("보일러 on.");
    }

    @Override
    public void turnOff() {
        System.out.println("보일러 off.");
    }
}
