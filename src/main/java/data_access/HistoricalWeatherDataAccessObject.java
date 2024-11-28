package data_access;

import java.io.*;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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
    public void saveWeather(Weather weather, String timeStamp) throws IOException {

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
//        final String weatherJson = jsonBuilder.toString();

        String relativePath = "src/main/resources/weather.json";
        File file = new File(relativePath);

        // Convert StringBuilder to String (JSON data to write)
//        final String weatherJson = jsonBuilder.toString();

        try (FileWriter fileWriter = new FileWriter(file, true)) {
            if (file.length() != 0) {
                // Add a new line before appending a new object if the file is not empty
                fileWriter.write(System.lineSeparator());
            }
            // Write JSON data to the file
            fileWriter.write(weatherJson);
            System.out.println("Successfully appended weather data to weather.json");
        } catch (IOException excep) {
            excep.printStackTrace();
            System.out.println("Failed to append weather data to weather.json");
        }
    }

    @Override
    public Weather getWeather(String city, String timestamp) throws IOException {
        // Get the weather data from the database
        // Read the JSON from the file
        final String filePath = "weather.json";
        try {
            URL resource = getClass().getClassLoader().getResource("weather.json");
            if (resource == null) {
                throw new FileNotFoundException("File not found: src/main/resources/weather.json");
            }

            // Read the content of the JSON file as a String
            final String jsonString = Files.readString(Paths.get(resource.toURI()), StandardCharsets.UTF_8);
            final JSONArray weatherArray = new JSONArray(jsonString);

//            final JSONArray weatherArray = weatherObject1.getJSONArray("weatherData");

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
