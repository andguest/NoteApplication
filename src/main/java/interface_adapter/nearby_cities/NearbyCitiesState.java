package interface_adapter.nearby_cities;

/**
 * The state information for the nearby list view model.
 */
public class NearbyCitiesState {
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
