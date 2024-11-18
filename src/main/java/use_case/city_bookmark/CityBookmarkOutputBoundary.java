package use_case.city_bookmark;

public interface CityBookmarkOutputBoundary {

    void presentSuccessView(CityBookmarkOutputData cityBookmarkOutputData);

    void prepareFailView(String errorMessage);
}
