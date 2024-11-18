package interface_adapter.search_result;

import interface_adapter.ViewModel;

public class SearchResultViewModel extends ViewModel<SearchResultState> {
    public SearchResultViewModel() {
        super("searchResult");
        setState(new SearchResultState());
    }
}
