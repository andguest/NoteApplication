package use_case.note.city_bookmark;

public interface CityBookmarkOutputBoundary {

    void presentSuccessView(CityBookmarkOutputData cityBookmarkOutputData);

    void prepareFailView(String errorMessage);
}
