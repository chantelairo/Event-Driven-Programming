
public class ForecastDisplay implements Observer {

    private float currentPressure = 1013;
    private float lastPressure;

    public ForecastDisplay(Subject weatherData) {
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {

        lastPressure = currentPressure;
        currentPressure = pressure;

        display();
    }

    public void display() {

        if (currentPressure > lastPressure) {
            System.out.println("Forecast: Improving weather!");
        } else if (currentPressure == lastPressure) {
            System.out.println("Forecast: More of the same.");
        } else {
            System.out.println("Forecast: Watch out for cooler, rainy weather.");
        }
    }
}
