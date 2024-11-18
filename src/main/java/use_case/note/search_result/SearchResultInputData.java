package use_case.note.search_result;

// Didn't implement the use case for past 24 hours. Undecided between a separate use case or putting it inside
// search bar.
public class SearchResultInputData {

    private String city;
    private final String date;

    public SearchResultInputData(String cityName, String date) {
        this.city = cityName;
        this.date = date;
    }

    public String getCity() {
        return this.city;
    }

    public String getDate() {
        return this.date;
    }
}
