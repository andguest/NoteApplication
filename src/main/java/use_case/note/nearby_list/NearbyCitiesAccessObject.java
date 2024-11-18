package use_case.note.nearby_list;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public abstract class NearbyCitiesAccessObject implements NearbyCitiesAccessInterface {
    private static final Float LOWER_LAT = -90.0f;
    private static final Float UPPER_LAT = 90.0f;
    private static final Float LOWER_LON = -180.0f;
    private static final Float UPPER_LON = 180.0f;
    private static final Float COMPARE_DIFF = 10.0f;

    @Override
    public List<String> getNearbyCities(Float latitude, Float longitude) throws IOException {
        if (latitude == null || longitude == null || latitude < LOWER_LAT || latitude > UPPER_LAT || longitude < LOWER_LON || longitude > UPPER_LON) {
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
    private static ArrayList<String> getCityNames(Float latitude, Float longitude, String jsonString) {
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
