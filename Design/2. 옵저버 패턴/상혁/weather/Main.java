package observer.weather;

public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        //옵저버가 주제 선택 과정 
        //주제에 옵저버가 등록됨
        CurrentConditionDisplay currentDisplay = new CurrentConditionDisplay(weatherData);

        //주제에 온도가 설정 -> 옵저버에게 update 메서드로 공지
        weatherData.setMeasurements(80, 65, 30.4f);
    }
}
