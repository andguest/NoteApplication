package use_case.bookmark_return;

public interface BookmarkReturnOutputBoundary {

    void prepareSuccessView(BookmarkReturnOutputData bookmarkReturnOutputData);

    void prepareFailView(String errorMessage);
}
