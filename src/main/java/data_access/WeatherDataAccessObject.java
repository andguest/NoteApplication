package data_access;

import entity.Weather;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;

/**
 * This class does stuff.
 **/

public class WeatherDataAccessObject {
    private static final String API_KEY = "7cce48d7f1f6785f54c0d08aa117ad83";
    private static String city;
    private static final int SUCCESS_CODE = 200;
    private static final String CONTENT_TYPE_LABEL = "Content-Type";
    private static final String CONTENT_TYPE_JSON = "application/json";
    private static final String STATUS_CODE_LABEL = "cod";
    // fixed
    private static final String WEATHER_LIST = "list";
    private static final String PASSWORD = "password";
    private static final String MESSAGE = "message";

    public WeatherDataAccessObject(String city) {
        this.city = city;
    }

    public Weather get(String username) {
        // Make an API call to get the user object.
        final OkHttpClient client = new OkHttpClient().newBuilder().build();

        // creating file
        final Request request = new Request.Builder()
                .url(String.format("http://api.openweathermap.org/data/2.5/forecast?q=%s&appid=" + API_KEY + "&units=metric", city))
                .addHeader("Content-Type", CONTENT_TYPE_JSON)
                .build();
        try {
            final Response response = client.newCall(request).execute();

            final JSONObject responseBody = new JSONObject(response.body().string());

            if (responseBody.getInt(STATUS_CODE_LABEL) == SUCCESS_CODE) {
                final JSONObject userJSONObject = responseBody.getJSONObject(WEATHER_LIST);

                // get individual items from the json object
                // final String name = userJSONObject.getString();

                // return new Weather(name); pass values in
            }
            else {
                throw new RuntimeException(responseBody.getString(MESSAGE));
            }
        }
        catch (IOException | JSONException ex) {
            throw new RuntimeException(ex);
        }
    }
}
