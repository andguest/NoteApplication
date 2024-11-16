package interface_adapter;
import interface_adapter.note.SearchResultState;

public class SearchResultViewModel extends ViewModel<SearchResultState> {
    public SearchResultViewModel() {
        super("searchResult");
        setState(new SearchResultState());
    }
}
