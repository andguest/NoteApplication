package use_case.note.nearby_cities;

public interface NearbyCitiesOutputBoundary {

    void presentSuccessView(NearbyCitiesOutputData nearbyCitiesOutputData);

    void prepareFailView(String errorMessage);
}
