package use_case.note.close_list;

public class CloseListOutputData {

    private final boolean useCaseFailed;

    public CloseListOutputData(boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
