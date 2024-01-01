public class Car implements Device {

    @Override
    public void turnOn() {
        System.out.println("자동차 on.");
    }

    @Override
    public void turnOff() {
        System.out.println("자동차 off.");
    }
}
