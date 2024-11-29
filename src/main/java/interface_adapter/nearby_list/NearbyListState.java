package interface_adapter.nearby_list;

import java.util.ArrayList;
import java.util.List;

/**
 * The state information for the nearby list view model.
 */
public class NearbyListState {
    private String[] cities;
    private String error;

    public String[] getCities() {
        return cities;
    }

    public void setCities(String[] cities) {
        this.cities = cities;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
