package interface_adapter.nearby_list;

import use_case.note.nearby_list.NearbyListInputBoundary;
import use_case.note.nearby_list.NearbyListInputData;

public class NearbyListController {
    private final NearbyListInputBoundary nearbyListInteractor;

    // Constructor that injects the use case's input boundary
    public NearbyListController(NearbyListInputBoundary nearbyListInteractor) {
        this.nearbyListInteractor = nearbyListInteractor;
    }

    /**
     * Executes the find nearby cities use case given the longitude and latitude of the current location.
     *
     * @param longitude the name of the city to search for
     * @param latitude the date to search for
     */
    public void execute(float longitude, float latitude) {
        // Create a NearbyListInputData object to encapsulate the input data
        final NearbyListInputData inputData = new NearbyListInputData(longitude, latitude);
        // Call the use case's execute method with the input data
        nearbyListInteractor.execute(inputData);
    }
}
