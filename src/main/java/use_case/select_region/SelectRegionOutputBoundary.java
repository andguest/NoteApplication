package use_case.select_region;

public interface SelectRegionOutputBoundary {

    void presentSuccessView(SelectRegionOutputData selectRegionOutputData);

    void prepareFailView(String errorMessage);
}
