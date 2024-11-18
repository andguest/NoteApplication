package use_case.note.bookmark_return;

public interface BookmarkReturnOutputBoundary {

    void prepareSuccessView(BookmarkReturnOutputData bookmarkReturnOutputData);

    void prepareFailView(String errorMessage);
}
