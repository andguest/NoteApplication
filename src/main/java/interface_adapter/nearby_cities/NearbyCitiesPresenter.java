package interface_adapter.nearby_cities;

import use_case.note.nearby_cities.NearbyCitiesOutputBoundary;
import use_case.note.nearby_cities.NearbyCitiesOutputData;

/**
 * The presenter for the nearby cities use case.
 */
public class NearbyCitiesPresenter implements NearbyCitiesOutputBoundary {
    private final NearbyCitiesViewModel nearbyCitiesViewModel;

    public NearbyCitiesPresenter(NearbyCitiesViewModel nearbyCitiesViewModel) {
        this.nearbyCitiesViewModel = nearbyCitiesViewModel;
    }

    /**
     * Prepares the success view for the NearbyList related Use Cases.
     *
     * @param response the output data
     */
    @Override
    public void presentSuccessView(NearbyCitiesOutputData response) {
        nearbyCitiesViewModel.getState().setCities(response.getCities());
        nearbyCitiesViewModel.getState().setError(null);
        nearbyCitiesViewModel.firePropertyChanged("NearbyList");
    }

    /**
     * Prepares the failure view for the NearbyList related Use Cases.
     *
     * @param errorMessage the explanation of the failure
     */
    @Override
    public void prepareFailView(String errorMessage) {
        nearbyCitiesViewModel.getState().setError(errorMessage);
        nearbyCitiesViewModel.firePropertyChanged();
    }
}
