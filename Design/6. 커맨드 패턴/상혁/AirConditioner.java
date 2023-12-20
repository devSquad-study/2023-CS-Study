public class AirConditioner implements Device {

    @Override
    public void turnOn() {
        System.out.println("에어컨 on.");
    }

    @Override
    public void turnOff() {
        System.out.println("에어컨 off.");
    }

    void setTemperature(int temperature) {
        if (temperature >= 26) {
            System.out.println("[ERROR] 26도 이상 설정할 수 없습니다.");
        } else {
            System.out.println("온도가 " + temperature + " 도로 설정됐습니다.");
        }
    }
}
