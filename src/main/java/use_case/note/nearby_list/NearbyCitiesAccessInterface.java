package use_case.note.nearby_list;

import java.io.IOException;
import java.util.List;

public interface NearbyCitiesAccessInterface {
    /**
     *
     * @param latitude
     * @param longitude
     * @return
     * @throws IOException
     */
    List<String> getNearbyCities(Float latitude, Float longitude) throws IOException;
}
