package interface_adapter.nearby_cities;

import interface_adapter.ViewModel;

/**
 * The view model for the nearby list view.
 */
public class NearbyCitiesViewModel extends ViewModel<NearbyCitiesState> {
    public NearbyCitiesViewModel() {
        super("nearbyList");
        setState(new NearbyCitiesState());
    }
}
