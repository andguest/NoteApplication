package interface_adapter.nearby_list;

import use_case.note.nearby_list.NearbyListOutputBoundary;
import use_case.note.nearby_list.NearbyListOutputData;

/**
 * The presenter for the nearby cities use case.
 */
public class NearbyListPresenter implements NearbyListOutputBoundary {
    private final NearbyListViewModel nearbyListViewModel;

    public NearbyListPresenter(NearbyListViewModel nearbyListViewModel) {
        this.nearbyListViewModel = nearbyListViewModel;
    }

    /**
     * Prepares the success view for the NearbyList related Use Cases.
     *
     * @param response the output data
     */
    @Override
    public void presentSuccessView(NearbyListOutputData response) {
        nearbyListViewModel.getState().setCities(response.getCities());
        nearbyListViewModel.getState().setError(null);
        nearbyListViewModel.firePropertyChanged("NearbyList");
    }

    /**
     * Prepares the failure view for the NearbyList related Use Cases.
     *
     * @param errorMessage the explanation of the failure
     */
    @Override
    public void prepareFailView(String errorMessage) {
        nearbyListViewModel.getState().setError(errorMessage);
        nearbyListViewModel.firePropertyChanged();
    }
}
