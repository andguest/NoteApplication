package use_case.note.nearby_list;

public interface NearbyListOutputBoundary {

    void presentSuccessView(NearbyListOutputData nearbyListOutputData);

    void prepareFailView(String errorMessage);
}
