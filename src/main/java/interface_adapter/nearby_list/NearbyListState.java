package interface_adapter.nearby_list;

import java.util.ArrayList;
import java.util.List;

/**
 * The state information for the nearby list view model.
 */
public class NearbyListState {
    private ArrayList<String> cities;
    private String error;

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = (ArrayList<String>) cities;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
