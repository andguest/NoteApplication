package data_access;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONObject;

import entity.Weather;
import use_case.note.HistoricalWeatherDataAccessInterface;

/**
 * This class provides the service of saving and getting historical weather data.
 */
public class HistoricalWeatherDataAccessObject implements HistoricalWeatherDataAccessInterface {
    @Override
    public void saveWeather(Weather weather, String timeStamp) {

        // Save the weather data to the database
        // Convert the Weather object to JSON
        final String nextLine = "\",\n";
        final StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n");
        jsonBuilder.append("  \"timeStamp\": \"" + timeStamp + nextLine);
        jsonBuilder.append("  \"city\": \"" + weather.getCityName() + nextLine);
        jsonBuilder.append("  \"longitude\": " + weather.getLon() + nextLine);
        jsonBuilder.append("  \"latitude\": ").append(weather.getLat()).append(nextLine);
        jsonBuilder.append("  \"temperature\": ").append(weather.getTemperature()).append(nextLine);
        jsonBuilder.append("  \"looks\": \"").append(weather.getWeather()).append(nextLine);
        jsonBuilder.append("  \"alertDescription\": \"").append(weather.getDescription()).append(nextLine);
        jsonBuilder.append("  \"humidity\": " + weather.getHumidity() + nextLine);
        jsonBuilder.append("  \"windSpeed\": " + weather.getWindSpeed() + nextLine);
        jsonBuilder.append("}");

        // Convert StringBuilder to String
        final String weatherJson = jsonBuilder.toString();

        // Write JSON to a file
        try (FileWriter fileWriter = new FileWriter("weather.json")) {
            fileWriter.write(weatherJson);
            System.out.println("Successfully wrote weather data to weather.json");
        }
        catch (IOException excep) {
            excep.printStackTrace();
        }
    }

    @Override
    public Weather getWeather(String city, String timestamp) throws IOException {
        // Get the weather data from the database
        // Read the JSON from the file
        final String filePath = "weather.json";
        try {
            // Reading the content of the JSON file into a String
            final String jsonString = Files.readString(Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                    .getResource(filePath)).toURI()));
            // Converting the JSON String to a JSONArray
            final JSONArray weatherArray = new JSONArray(jsonString);
            // Iterating over the JSONArray
            for (int i = 0; i < weatherArray.length(); i++) {
                // Getting the JSONObject at the index i
                final JSONObject weatherObject = weatherArray.getJSONObject(i);
                // Getting the city from the JSONObject
                final String cityNameCall = weatherObject.getString("city");
                // Getting the timestamp from the JSONObject
                final String timeStamp = weatherObject.getString("timeStamp");
                // Checking if the city and timestamp match the input
                if (cityNameCall.equals(city) && timeStamp.equals(timestamp)) {
                    // Create weather object
                    //TODO: Changed weather declaration, uncertain if it there is key "description" and
                    // "alertDescription" for historical weather. If no we need to change Weather class.
                    final Weather weather = new Weather(
                            cityNameCall,
                            weatherObject.getInt("temperature"),
                            weatherObject.getString("looks"),
                            weatherObject.getString("description"),
                            weatherObject.getInt("windSpeed"),
                            weatherObject.getInt("longitude"),
                            weatherObject.getInt("humidity"),
                            weatherObject.getInt("longitude"),
                            weatherObject.getInt("latitude"),
                            weatherObject.getString("alertDescription")
                    );
                    return weather;
                }

            }
        }
        catch (IOException | URISyntaxException exe) {
            exe.printStackTrace();
        }
        throw new IOException("Weather data not found");
    }

}
