package use_case.note;

import entity.Weather;

import java.io.IOException;
import java.util.Map;

/**
 * Interface for the HistoricalWeatherDataAccessObject. It consists of methods for
 * saving the weather.
 */
public interface HistoricalWeatherDataAccessInterface {
    /**
     * Saves the weather data.
     * @param weather the weather data to save
     * @throws IOException if there is an error saving the weather data
     */
    void saveWeather(Weather weather, String timstamp) throws IOException;

    /**
     * Gets the weather data.
     * @param city the city to get the weather data for
     * @param timestamp the timestamp of the weather data
     * @throws IOException if there is an error getting the weather data
     */
    Weather getWeather(String city, String timestamp) throws IOException;
}
