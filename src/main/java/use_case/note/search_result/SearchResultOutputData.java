package use_case.note.search_result;

public class SearchResultOutputData {

    private final String location;
    private final String weather;
    private final boolean useCaseFailed;

    public SearchResultOutputData(String location, String weather, boolean useCaseFailed) {
        this.location = location;
        this.weather = weather;
        this.useCaseFailed = useCaseFailed;
    }

    public String getLocation() {
        return location;
    }

    public String getWeather() {return weather;}

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
