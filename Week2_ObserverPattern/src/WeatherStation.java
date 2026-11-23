
public class WeatherStation {

    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay =
                new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(28, 65, 1012);
        weatherData.setMeasurements(30, 70, 1010);
        weatherData.setMeasurements(26, 60, 1015);

    }
}
