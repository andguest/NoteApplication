package data_access;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import entity.Weather;
import org.json.JSONException;
import use_case.note.CompareCities.CompareCitiesDataAccessInterface;

/**
 * In-memory implementation of the DAO for storing weather data. This implementation does
 * NOT persist data between runs of the program.
 */
public class InMemoryUserDataAccessObject implements CompareCitiesDataAccessInterface {
    private final Map<String, Weather> weathers = new HashMap<>();

    @Override
    public Weather getWeather(String identifier) throws IOException {
        if ("Toronto".equalsIgnoreCase(identifier)) {
            final Weather torontoweather = new Weather("Toronto", 10.5, "rain",
                    "first description", 0.0, 1, 2, 3.0, 4.0, "No alerts");
            return torontoweather;
        }
        else if ("Tokyo".equalsIgnoreCase(identifier)) {
            final Weather tokyoweather = new Weather("Tokyo", 1.0, "cloud", "second description",
                    2.0, 2, 1000, 20.0, 25.0, "Alerts");
            return tokyoweather;
        }
        throw new IOException("Failed to fetch weather data");
    }

    @Override
    public boolean isCityExist(String cityname){
        if (cityname.equals("Toronto")||cityname.equals("Tokyo")){
            return true;
        }
        return false;
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
