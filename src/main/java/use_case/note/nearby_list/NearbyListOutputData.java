package use_case.note.nearby_list;

import java.util.ArrayList;
import java.util.List;

public class NearbyListOutputData {

    private final ArrayList<String> cities;
    private final boolean useCaseFailed;

    public NearbyListOutputData(List<String> cities, boolean useCaseFailed) {
        this.cities = (ArrayList<String>) cities;
        this.useCaseFailed = useCaseFailed;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

    public List<String> getCities() {
        return cities;
    }
}
