package use_case.note.search_return;

/**
 * // Input is one click on "return."
 */
public class SearchReturnInputData {
    private final String city;

    public SearchReturnInputData(String cityName) {
        this.city = cityName;
    }

    public String getCity() {
        return this.city;
    }
}
