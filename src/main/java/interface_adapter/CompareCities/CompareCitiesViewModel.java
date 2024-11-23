package interface_adapter.CompareCities;

import interface_adapter.ViewModel;

public class CompareCitiesViewModel extends ViewModel<CompareCitiesState> {
    public CompareCitiesViewModel() {
        super("CompareCities");
        setState(new CompareCitiesState());
    }
}
