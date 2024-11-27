package interface_adapter.CompareCities;

import interface_adapter.ViewModel;
/**
 * The View Model for the Compare Cities Use case.
 */

public class CompareCitiesViewModel extends ViewModel<CompareCitiesState> {
    public CompareCitiesViewModel() {
        super("CompareCities");
        setState(new CompareCitiesState());
    }
}
