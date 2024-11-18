package use_case.nearby_list;

public class NearbyListOutputData {

    private final String[] cities;
    private final boolean useCaseFailed;

    public NearbyListOutputData(String[] cities, boolean useCaseFailed) {
        this.cities = cities;
        this.useCaseFailed = useCaseFailed;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
