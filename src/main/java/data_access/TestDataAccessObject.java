package data_access;

import entity.Weather;
import use_case.note.WeatherDataAccessInterface;

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

    @Override
    public Weather getWeather(String citySearch) {
        return citytoweather.get(citySearch);
    }
}
