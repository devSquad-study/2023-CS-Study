package commandPattern;

import commandPattern.IoTDevice.AirConditioner;
import commandPattern.IoTDevice.Car;
import commandPattern.IoTDevice.GasStove;
import commandPattern.IoTDevice.Heater;
import commandPattern.command.*;

import java.util.Scanner;

public class DdokDdoki {
    private final Invoker invoker;
    private final GasStove gasStove;
    private final AirConditioner airConditioner;
    private final Heater heater;
    private final Car car;
    Scanner scanner = new Scanner(System.in);

    public DdokDdoki() {
        heater = new Heater();
        invoker = new Invoker();
        gasStove = new GasStove();
        airConditioner = new AirConditioner();
        car = new Car();
        run();
    }

    public void printOptions() {
        System.out.println("똑똑이 기능 목록:");
        System.out.println("1. 가스레인지 on/off");
        System.out.println("2. 에어컨 on/off");
        System.out.println("3. 보일러 on/off");
        System.out.println("4. 자동차 on/off");
        // 필요한 기능들에 따라 옵션을 추가할 수 있어요
    }

    public void processUserInput(int option) {

        switch (option) {
            case 1:
                // 가스레인지 기능
                System.out.print("가스레인지를 켜려면 'on', 끄려면 'off'를 입력하세요: ");
                String gasStoveAction = scanner.next();
                if (gasStoveAction.equals("on")) {
                    invoker.setCommand(new PowerOn(gasStove));
                    invoker.buttonWasPressed();
                }
                else {
                    invoker.setCommand(new PowerOff(gasStove));
                    invoker.buttonWasPressed();
                }
                break;
            case 2:
                // 에어컨 기능
                System.out.print("에어컨을 켜려면 'on', 끄려면 'off'를 입력하세요: ");
                String airConditionerAction = scanner.next();
                if (airConditionerAction.equals("on")) {
                    invoker.setCommand(new PowerOn(airConditioner));
                    invoker.buttonWasPressed();
                    System.out.print("에어컨 온도를 설정해주세요: ");
                    Integer airConditionerTemp  = Integer.valueOf(scanner.next());
                    invoker.setCommand(new SetTemperature(airConditioner));
                    invoker.buttonWasPressed(airConditionerTemp);
                }
                else {
                    invoker.setCommand(new PowerOff(airConditioner));
                    invoker.buttonWasPressed();
                }
                break;
            case 3:
                // 난방 기능
                System.out.print("난방을 켜려면 'on', 끄려면 'off'를 입력하세요: ");
                String heaterAction = scanner.next();
                if (heaterAction.equals("on")) {
                    invoker.setCommand(new PowerOn(heater));
                    invoker.buttonWasPressed();
                    System.out.print("난방 온도를 설정해주세요: ");
                    Integer heaterTemp  = Integer.valueOf(scanner.next());
                    invoker.setCommand(new SetTemperature(heater));
                    invoker.buttonWasPressed(heaterTemp);
                }
                else {
                    invoker.setCommand(new PowerOff(heater));
                    invoker.buttonWasPressed();
                }
                break;
            case 4:
                // 자동차 기능
                if (car.getPower()) {  // 자동차 시동이 걸려있을 때
                    System.out.print("자동차 시동이 켜져있습니다. 끄려면 'off'를, 다른 기능을 이용하려면 continue를 입력하세요:");
                    String carAction = scanner.next();
                    if (carAction.equals("off")) {
                        invoker.setCommand(new PowerOff(car));
                        invoker.buttonWasPressed();
                    } else {
                        carSetting();
                    }
                    break;
                } else {     // 자동차 시동이 꺼져있을 때
                    System.out.print("자동차 시동이 꺼져있습니다. 켜려면 'on'을 입력하세요.");
                    String carAction = scanner.next();
                    if (carAction.equals("on")) {
                        invoker.setCommand(new PowerOn(car));
                        invoker.buttonWasPressed();
                    }
                    break;
                }
            default:
                System.out.println("잘못된 옵션입니다.");
        }
    }

    public void carSetting() {
        System.out.println("1. 에어컨 on/off");
        System.out.println("2. 히터 on/off");
        String carAction = scanner.next();

        switch (Integer.parseInt(carAction)) {
            // 자동차의 에어컨
            case 1:
                System.out.print("자동차의 에어컨을 켜려면 'on', 끄려면 'off'를 입력하세요: ");
                String airConditionerAction = scanner.next();
                if (airConditionerAction.equals("on")) {
                    invoker.setCommand(new PowerOn(car.airConditioner));
                    invoker.buttonWasPressed();
                    System.out.print("에어컨 온도를 설정해주세요: ");
                    Integer airConditionerTemp  = Integer.valueOf(scanner.next());
                    invoker.setCommand(new SetTemperature(car.airConditioner));
                    invoker.buttonWasPressed(airConditionerTemp);
                }
                else {
                    invoker.setCommand(new PowerOff(car.airConditioner));
                    invoker.buttonWasPressed();
                }
                break;
            // 자동차의 히터
            case 2:
                System.out.print("자동차의 히터를 켜려면 'on', 끄려면 'off'를 입력하세요: ");
                String heaterAction = scanner.next();
                if (heaterAction.equals("on")) {
                    invoker.setCommand(new PowerOn(car.heater));
                    invoker.buttonWasPressed();
                    System.out.print("난방 온도를 설정해주세요: ");
                    Integer heaterTemp  = Integer.valueOf(scanner.next());
                    invoker.setCommand(new SetTemperature(heater));
                    invoker.buttonWasPressed(heaterTemp);
                }
                else {
                    invoker.setCommand(new PowerOff(car.heater));
                    invoker.buttonWasPressed();
                }
                break;
            default:
                System.out.println("잘못된 옵션입니다.");
        }
    }

        public void run() {
            boolean running = true;

            while (running) {
                printOptions();
                System.out.print("실행할 기능을 선택하세요 (숫자 입력, 종료는 0): ");
                int option = scanner.nextInt();

                if (option == 0) {
                    running = false;
                    System.out.println("똑똑이를 종료합니다.");
                } else {
                    processUserInput(option);
                }
            }
            scanner.close();
        }
}