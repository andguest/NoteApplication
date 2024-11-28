package data_access;

import entity.Weather;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import use_case.note.CompareCities.CompareCitiesDataAccessInterface;
import use_case.note.WeatherDataAccessInterface;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class runs the API and creates a weather DAO.
 **/

public class WeatherDataAccessObject implements WeatherDataAccessInterface, CompareCitiesDataAccessInterface {
    private static final String API_KEY = "7cce48d7f1f6785f54c0d08aa117ad83";
    private static final String MAIN = "main";
    //    private static String city;
    private static final int SUCCESS_CODE = 200;
    private static final String CONTENT_TYPE_JSON = "application/json";
    private static final String STATUS_CODE_LABEL = "cod";
    private static final String WEATHER_LIST = "list";
    private static final String MESSAGE = "This city is not found";
    private boolean cityexist;
    private final Map<String, Weather> citytoweather = new HashMap<>();

    @Override
    public boolean isCityExist(String citySearch) {
        final OkHttpClient client = new OkHttpClient().newBuilder().build();

        // Create a request to the OpenWeather API
        final Request request = new Request.Builder()
                .url(String.format("http://api.openweathermap.org/data/2.5/forecast?q=%s&appid=%s&units=metric", citySearch, API_KEY))
                .addHeader("Content-Type", CONTENT_TYPE_JSON)
                .build();

        try {
            final Response response = client.newCall(request).execute();

            // Parse the response
            final JSONObject responseBody = new JSONObject(response.body().string());

            // Check if the status code is 200 (Success)
            if (responseBody.getInt(STATUS_CODE_LABEL) == SUCCESS_CODE) {
                // City exists, as the API returned successful data
                return true;
            }
            else {
                // City doesn't exist (API returned a different code or error message)
                return false;
            }
        }
        catch (IOException | JSONException ex) {
            // If there was an error with the API call (e.g., network error, parsing error), assume city doesn't exist
            return false;
        }
    }

    @Override
    public Weather getWeather(String citySearch) throws IOException {
        // Make an API call to get the user object.
        final OkHttpClient client = new OkHttpClient().newBuilder().build();

        // creating file
        final Request request = new Request.Builder()
                .url(String.format("http://api.openweathermap.org/data/2.5/forecast?q=%s&appid="
                        + API_KEY + "&units=metric", citySearch))
                .addHeader("Content-Type", CONTENT_TYPE_JSON)
                .build();
        try {
            final Response response = client.newCall(request).execute();

            final JSONObject responseBody = new JSONObject(response.body().string());

            if (responseBody.getInt(STATUS_CODE_LABEL) == SUCCESS_CODE) {
                final JSONObject weatherJSON = responseBody.getJSONArray(WEATHER_LIST).getJSONObject(0);
                this.cityexist = true;
                // get individual items from the json object
                final JSONObject coordJSON = responseBody.getJSONObject("city").getJSONObject("coord");
                final double lon = coordJSON.getDouble("lon");
                final double lat = coordJSON.getDouble("lat");

                final int temp = (int) weatherJSON.getJSONObject(MAIN).getDouble("temp");
                final int humidity = (int) weatherJSON.getJSONObject(MAIN).getDouble("humidity");
                final int windspeed = (int) weatherJSON.getJSONObject("wind").getDouble("speed");

                // final String looks = weatherJSON.getJSONObject("weather").getString(MAIN);
                final String looks = weatherJSON.getJSONArray("weather").getJSONObject(0).getString(MAIN);
                final int visibility = weatherJSON.getInt("visibility");
                // final String description = weatherJSON.getJSONObject("weather").getString("description");
                final String description = weatherJSON.getJSONArray("weather").getJSONObject(0).getString("description");
                String alertDescription = "no weather alert";
                if (weatherJSON.has("alerts")) {
                    final JSONArray alertsArray = weatherJSON.getJSONArray("alerts");
                    if (alertsArray.length() > 0) {
                        alertDescription = alertsArray.getJSONObject(0).getString("description");
                    }
                }

                return new Weather(citySearch, temp, looks, description, windspeed, humidity,
                        visibility, lon, lat, alertDescription);
            }
            else {
                throw new IOException(responseBody.getString(MESSAGE));
            }
        }
        catch (IOException | JSONException ex) {
            throw new IOException(ex);
        }
    }

    @Override
    public void saveWeatherinfor(Weather weather) {
        citytoweather.put(weather.getCityName(), weather);
    }

    @Override
    public Map<String, Weather> getcitytoweather() {
        return this.citytoweather;
    }

    /*
     * This method "clean" the elements inside this.citytoweather we don't want to accumulate pairs.
     */
    @Override
    public void clearcitytoweather() {
        this.citytoweather.clear();
    }
}