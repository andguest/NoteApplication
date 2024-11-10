package use_case.note.select_region;

public class SelectRegionOutputData {
    private final String location;
    private final String weather;
    private final boolean useCaseFailed;

    public SelectRegionOutputData(String location, String weather, boolean useCaseFailed) {
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
