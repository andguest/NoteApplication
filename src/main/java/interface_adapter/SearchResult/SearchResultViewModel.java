package interface_adapter.SearchResult;

import interface_adapter.ViewModel;
/**
 *  View Model for the Search Result use case.
 */

public class SearchResultViewModel extends ViewModel<SearchResultState> {
    public SearchResultViewModel() {
        super("searchResult");
        setState(new SearchResultState());
    }
}
