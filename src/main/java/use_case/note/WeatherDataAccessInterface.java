package use_case.note;

import entity.Weather;
import java.io.IOException;
import java.util.Map;

/**
 * Interface for the WeatherDAO. It consists of methods for
 * loading the weather.
 */
public interface WeatherDataAccessInterface {

    /**
     * Creates the Weather.
     * @param city the weather is displayed for
     * @return the weather information
     * @throws IOException if the city does not exist or oi.
     */
    Weather getWeather(String city) throws IOException;

    Map saveWeather(String city, Map weather) throws IOException;
}
