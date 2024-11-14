package use_case.note.convert_farenheit;

public class ConvertFarenheitOutputData {
    private final boolean useCaseFailed;

    public ConvertFarenheitOutputData(boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
