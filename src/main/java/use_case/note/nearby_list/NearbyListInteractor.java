package use_case.note.nearby_list;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The interactor for the nearby cities use case.
 */
public class NearbyListInteractor implements NearbyListInputBoundary {
    private final NearbyListOutputBoundary outputBoundary;
    private final NearbyCitiesAccessInterface cityDataAccess;

    public NearbyListInteractor(NearbyListOutputBoundary outputBoundary, NearbyCitiesAccessInterface cityDataAccess) {
        this.outputBoundary = outputBoundary;
        this.cityDataAccess = cityDataAccess;
    }

    @Override
    public void execute(NearbyListInputData nearbyListInputData) {
        try {
            final double latitude = nearbyListInputData.getLatitude();
            final double longitude = nearbyListInputData.getLongitude();
            final String[] cities = cityDataAccess.getNearbyCities(latitude, longitude).toArray(new String[0]);
            final NearbyListOutputData outputData = new NearbyListOutputData(cities, false);
            outputBoundary.presentSuccessView(outputData);
        }
        catch (IOException exception) {
            outputBoundary.prepareFailView("Error: " + exception.getMessage());
        }
    }
}
