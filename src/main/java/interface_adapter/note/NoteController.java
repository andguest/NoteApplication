package interface_adapter.note;

import use_case.note.ConvertInputBoundary;

/**
 * Controller for our Note related Use Cases.
 */
public class NoteController {

    private final ConvertInputBoundary noteInteractor;

    public NoteController(ConvertInputBoundary noteInteractor) {
        this.noteInteractor = noteInteractor;
    }

    /**
     * Executes the Note related Use Cases.
     * @param note the note to be recorded
     */
    public void execute(String note) {
        if (note != null) {
            noteInteractor.executeSave(note);
        }
        else {
            noteInteractor.executeRefresh();
        }
    }
}
