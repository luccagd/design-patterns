package observer.implementation;

import observer.implementation.observers.CurrentConditionsDisplay;
import observer.implementation.observers.HeatIndexDisplay;
import observer.implementation.subjects.WeatherData;

public class WeatherStationTestDrive {
  public static void main(String[] args) {
    WeatherData weatherData = new WeatherData();

    CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
    HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

    weatherData.setMeasurements(80, 65, 30.4f);
    weatherData.setMeasurements(82, 70, 29.2f);
    weatherData.setMeasurements(78, 90, 29.2f);
  }
}
