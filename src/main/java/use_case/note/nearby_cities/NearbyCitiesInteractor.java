package use_case.note.nearby_cities;

import java.io.IOException;

/**
 * The interactor for the nearby cities use case.
 */
public class NearbyCitiesInteractor implements NearbyCitiesInputBoundary {
    private final NearbyCitiesOutputBoundary outputBoundary;
    private final NearbyCitiesAccessInterface cityDataAccess;

    public NearbyCitiesInteractor(NearbyCitiesOutputBoundary outputBoundary,
                                  NearbyCitiesAccessInterface cityDataAccess) {
        this.outputBoundary = outputBoundary;
        this.cityDataAccess = cityDataAccess;
    }

    @Override
    public void execute(NearbyCitiesInputData nearbyCitiesInputData) {
        try {
            final double latitude = nearbyCitiesInputData.getLatitude();
            final double longitude = nearbyCitiesInputData.getLongitude();
            final String[] cities = cityDataAccess.getNearbyCities(latitude, longitude).toArray(new String[0]);
            final NearbyCitiesOutputData outputData = new NearbyCitiesOutputData(cities, false);
            outputBoundary.presentSuccessView(outputData);
        }
        catch (IOException exception) {
            outputBoundary.prepareFailView("Error: " + exception.getMessage());
        }
    }
}
