package interface_adapter.SearchResult;

import interface_adapter.ViewModel;

public class SearchResultViewModel extends ViewModel<SearchResultState> {
    public SearchResultViewModel() {
        super("searchResult");
        setState(new SearchResultState());
    }
}
