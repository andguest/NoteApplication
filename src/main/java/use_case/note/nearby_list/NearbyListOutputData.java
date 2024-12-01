package use_case.note.nearby_list;

import java.util.ArrayList;
import java.util.List;

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

    public String[] getCities() {
        return cities;
    }
}
