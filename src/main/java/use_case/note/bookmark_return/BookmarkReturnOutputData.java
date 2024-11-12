package use_case.note.bookmark_return;

public class BookmarkReturnOutputData {

    private final boolean useCaseFailed;

    public BookmarkReturnOutputData(boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
