package use_case.city_bookmark;

import java.util.ArrayList;

public class CityBookmarkOutputData {

    private final String[] cities;
    private final boolean useCaseFailed;

    public CityBookmarkOutputData(String[] cities, boolean useCaseFailed) {
        this.cities = cities;
        this.useCaseFailed = useCaseFailed;
    }

    public String getCities() {
        return cities;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
