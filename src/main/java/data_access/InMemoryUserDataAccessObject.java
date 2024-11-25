package data_access;

import java.util.HashMap;
import java.util.Map;

import entity.Weather;
import use_case.note.CompareCities.CompareCitiesDataAccessInterface;

/**
 * In-memory implementation of the DAO for storing weather data. This implementation does
 * NOT persist data between runs of the program.
 */
public class InMemoryUserDataAccessObject implements CompareCitiesDataAccessInterface {
    private final Map<String, Weather> weathers = new HashMap<>();

    @Override
    public boolean isCityexist(String identifier) {
        return weathers.containsKey(identifier);
    }

    @Override
    public Weather getWeather(String identifier) {
        if (isCityexist(identifier)) {
            if ("Toronto".equalsIgnoreCase(identifier)) {
                final Weather torontoweather = new Weather("Toronto", 10.5, "rain", null, 0);
                return torontoweather;
            }
            else {
                final Weather tokyoweather = new Weather("Tokyo",1.0, "cloud", null, 1 );
                return tokyoweather;
            }
        }
        else {
            return null;
        }
    }

    @Override
    public void saveWeatherinfor(Weather weather) {
        weathers.put(weather.getCityName(), weather);
    }

    @Override
    public Map getcitytoweather() {
        return weathers;
    }

    @Override
    public void clearcitytoweather() {
        weathers.clear();
    }
}
