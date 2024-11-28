package interface_adapter.nearby_list;

import use_case.note.nearby_list.NearbyListInputBoundary;
import use_case.note.nearby_list.NearbyListInputData;

/**
 * Controller for the nearby list use case.
 */
public class NearbyListController {
    private final NearbyListInputBoundary nearbyListInteractor;

    public NearbyListController(NearbyListInputBoundary nearbyListInteractor) {
        this.nearbyListInteractor = nearbyListInteractor;
    }

    /**
     * Executes the find nearby cities use case given the longitude and latitude of the current location.
     *
     * @param longitude the current longitude
     * @param latitude the current latitude
     */
    public void execute(double longitude, double latitude) {
        // Create a NearbyListInputData object to encapsulate the input data
        final NearbyListInputData inputData = new NearbyListInputData(longitude, latitude);
        // Call the use case's execute method with the input data
        nearbyListInteractor.execute(inputData);
    }
}
