public class Main {
    public static void main(String[] args) {
        GasStove gasStove = new GasStove();
        AirConditioner airConditioner = new AirConditioner();
        Boiler boiler = new Boiler();
        Car car = new Car();

        RemoteControl remoteControl = new RemoteControl();

        remoteControl.setCommand(new TurnOnCommand(gasStove));
        remoteControl.pressButton();

        remoteControl.setCommand(new TurnOnCommand(boiler));
        remoteControl.pressButton();

        remoteControl.setCommand(new TurnOnCommand(airConditioner));
        remoteControl.pressButton();

        remoteControl.setCommand(new SetTemperatureCommand(airConditioner, 25));
        remoteControl.pressButton();

        remoteControl.setCommand(new SetTemperatureCommand(airConditioner, 28));
        remoteControl.pressButton();

        remoteControl.setCommand(new TurnOnCommand(car));
        remoteControl.pressButton();
    }
}
