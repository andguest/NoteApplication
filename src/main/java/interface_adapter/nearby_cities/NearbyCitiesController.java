package interface_adapter.nearby_cities;

import use_case.note.nearby_cities.NearbyCitiesInputBoundary;
import use_case.note.nearby_cities.NearbyCitiesInputData;

/**
 * Controller for the nearby list use case.
 */
public class NearbyCitiesController {
    private final NearbyCitiesInputBoundary nearbyListInteractor;

    public NearbyCitiesController(NearbyCitiesInputBoundary nearbyListInteractor) {
        this.nearbyListInteractor = nearbyListInteractor;
    }

    /**
     * Executes the find nearby cities use case given the longitude and latitude of the current location.
     *
     * @param longitude the current longitude
     * @param latitude the current latitude
     */
    public void execute(double longitude, double latitude) {
        // Create a NearbyCitiesInputData object to encapsulate the input data
        final NearbyCitiesInputData inputData = new NearbyCitiesInputData(longitude, latitude);
        // Call the use case's execute method with the input data
        nearbyListInteractor.execute(inputData);
    }
}
