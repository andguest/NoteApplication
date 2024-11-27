package use_case.note.CompareCities;

import entity.Weather;

import java.io.IOException;
import java.util.Map;

/**
 * Interface for the Comparing Cities Use case.
 */
public interface CompareCitiesDataAccessInterface {
    /**
     * Check if City exists.
     * @param cityName the weather is displayed for
     * @return true if city exists
     * @throws IOException if the city does not exist or oi.
     */
    boolean isCityExist(String cityName);

    /**
     * Creates the Weather.
     * @param cityname the weather is displayed for
     * @return the weather information
     * @throws IOException if the city does not exist or oi.
     */
    Weather getWeather(String cityname) throws IOException;

    /**
     * Saves the Weather.
     * @param weather save weather infor of a city to a map. since there is method getCityname in Weather Object.
     * this method can work without have cityname as its input.
     */
    void saveWeatherinfor(Weather weather);

    /**
     * Returns the City.
     * @return the city
     * */
    Map getcitytoweather();

    /**
     * This method "clean" the elements inside this.citytoweather we don't want to accumulate pairs.
     */
    void clearcitytoweather();
}
