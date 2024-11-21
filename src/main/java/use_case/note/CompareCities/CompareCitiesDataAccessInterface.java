package use_case.note.CompareCities;

import entity.Weather;

import java.io.IOException;

/**
 * Interface for the Comparing Cities Use case.
 */
public interface CompareCitiesDataAccessInterface {
    /**
     * Check if City exists.
     * @param cityname the weather is displayed for
     * @return if city exists
     */
    boolean citynotexist(String cityname);

    /**
     * Creates the Weather.
     * @param cityname the weather is displayed for
     * @return the weather information
     * @throws IOException if the city does not exist or oi.
     */
    Weather getWeather(String cityname) throws IOException;

    /**
     * Saves the Weather.
     * @param cityname the weather is saved
     */
    void saveWeather(String cityname);

    /**
     * Returns the City.
     * @return the city
     * */
    String getCurrentCity();

    /**
     * Sets city.
     * @param cityname the weather is for
     */
    void setCurrentCity(String cityname);
}
