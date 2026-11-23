
public class StatisticsDisplay implements Observer {

    private float maxTemp = Float.NEGATIVE_INFINITY;
    private float minTemp = Float.POSITIVE_INFINITY;
    private float tempSum = 0;
    private int numReadings = 0;

    public StatisticsDisplay(Subject weatherData) {
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {

        tempSum += temperature;
        numReadings++;

        if (temperature > maxTemp) {
            maxTemp = temperature;
        }

        if (temperature < minTemp) {
            minTemp = temperature;
        }

        display();
    }

    public void display() {
        System.out.println("Weather Statistics: Avg = "
                + (tempSum / numReadings)
                + " C, Max = " + maxTemp
                + " C, Min = " + minTemp + " C");
    }
}
