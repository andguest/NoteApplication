package use_case.nearby_list;

public interface NearbyListOutputBoundary {

    void presentSuccessView(NearbyListOutputData nearbyListOutputData);

    void prepareFailView(String errorMessage);
}
