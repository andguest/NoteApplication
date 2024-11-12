package use_case.note.select_region;

public interface SelectRegionOutputBoundary {

    void presentSuccessView(SelectRegionOutputData selectRegionOutputData);

    void prepareFailView(String errorMessage);
}
