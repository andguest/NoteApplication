package use_case.note.nearby_cities;

import java.io.IOException;
import java.util.List;

/**
 * Interface for generating list of nearby cities.
 */
public interface NearbyCitiesAccessInterface {
    List<String> getNearbyCities(double latitude, double longitude) throws IOException;
}
