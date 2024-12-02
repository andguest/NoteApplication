package data_access;

import entity.Weather;
import use_case.note.WeatherDataAccessInterface;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class TestDataAccessObject implements WeatherDataAccessInterface {

    private final Map<String, Weather> citytoweather = new HashMap<>();

    /**
     * Stores a Weather object into the citytoweather map in the class.
     * @param weather a Weather object containing the city name and all other weather information.
     */
    public void saveWeatherinfor(Weather weather) {
        citytoweather.put(weather.getCityName(), weather);
    }

    /**
     * Returns a Weather object that matches citySearch, or throws IOException if no Weather object matches citySearch.
     * @param citySearch a String of the city name.
     */
    @Override
    public Weather getWeather(String citySearch) throws IOException {
        if (citytoweather.containsKey(citySearch)) {
            return citytoweather.get(citySearch);
        }
        else {
            throw new IOException("This city is not found");
        }
    }
}
