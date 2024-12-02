package use_case.note.nearby_cities;

public class NearbyCitiesOutputData {

    private final String[] cities;
    private final boolean useCaseFailed;

    public NearbyCitiesOutputData(String[] cities, boolean useCaseFailed) {
        this.cities = cities;
        this.useCaseFailed = useCaseFailed;
    }

    public String[] getCities() {
        return cities;
    }
}
