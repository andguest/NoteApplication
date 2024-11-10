package use_case.note.searchResult;

public class SearchInputData {
    private final String cityName;

    public SearchInputData(String cityName) {
        this.cityName = cityName;
    }

    public String getCity() {
        return cityName;
    }
}
