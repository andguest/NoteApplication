package interface_adapter.nearby_list;

import interface_adapter.ViewModel;

/**
 * The view model for the nearby list view.
 */
public class NearbyListViewModel extends ViewModel<NearbyListState> {
    public NearbyListViewModel() {
        super("nearbyList");
        setState(new NearbyListState());
    }
}
