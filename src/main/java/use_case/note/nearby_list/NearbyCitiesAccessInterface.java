package use_case.note.nearby_list;

import java.io.IOException;
import java.util.List;

/**
 * Interface for generating list of nearby cities.
 */
public interface NearbyCitiesAccessInterface {
    List<String> getNearbyCities(Float latitude, Float longitude) throws IOException;
}
