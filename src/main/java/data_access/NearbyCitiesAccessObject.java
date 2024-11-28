package data_access;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import use_case.note.nearby_list.NearbyCitiesAccessInterface;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides the service of getting nearby cities.
 */
public abstract class NearbyCitiesAccessObject implements NearbyCitiesAccessInterface {
    private static final double LOWER_LAT = -90.0;
    private static final double UPPER_LAT = 90.0;
    private static final double LOWER_LON = -180.0;
    private static final double UPPER_LON = 180.0;
    private static final double COMPARE_DIFF = 10.0;

    @Override
    public List<String> getNearbyCities(double latitude, double longitude) throws IOException {
        if (latitude < LOWER_LAT || latitude > UPPER_LAT || longitude < LOWER_LON || longitude > UPPER_LON) {
            throw new IOException();
        }
        try {
            final String jsonString = Files
                    .readString(Paths.get(getClass().getClassLoader().getResource("cities_list.json").toURI()));
            return getCityNames(latitude, longitude, jsonString);
        }
        catch (IOException | URISyntaxException ex) {
            throw new IOException();
        }
    }

    @NotNull
    private static ArrayList<String> getCityNames(double latitude, double longitude, String jsonString) {
        final JSONArray jsonArray = new JSONArray(jsonString);

        final ArrayList<String> nearbyCities = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            final JSONObject city = jsonArray.getJSONObject(i);
            if (Math.abs(city.getInt("lat") - latitude) < COMPARE_DIFF
                    && Math.abs(city.getInt("lon") - longitude) < COMPARE_DIFF) {
                nearbyCities.add(city.getString("name"));
            }
        }
        return nearbyCities;
    }
}
