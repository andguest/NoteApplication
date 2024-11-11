package use_case.note.search_return;

public class SearchReturnOutputData {

    private final String location;
    private final String weather;
    private final boolean useCaseFailed;

    public SearchReturnOutputData(String location, String weather, boolean useCaseFailed) {
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
