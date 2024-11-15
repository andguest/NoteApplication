package use_case.note.search_result;

// Didn't implement the use case for past 24 hours. Undecided between a separate use case or putting it inside
// search bar.
public class SearchResultInputData {

    private String city;

    public SearchResultInputData(String cityName) {
        this.city = cityName;
    }

    public String getCity() {
        return this.city;
    }
}
