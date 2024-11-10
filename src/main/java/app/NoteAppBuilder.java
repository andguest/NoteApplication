package app;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import interface_adapter.note.NoteController;
import interface_adapter.note.NotePresenter;
import interface_adapter.note.NoteViewModel;
import use_case.note.WeatherDataAccessInterface;
import use_case.note.NoteInteractor;
import use_case.note.NoteOutputBoundary;
import view.NoteView;

/**
 * Builder for the Note Application.
 */
public class NoteAppBuilder {
    public static final int HEIGHT = 750;
    public static final int WIDTH = 1500;
    private WeatherDataAccessInterface noteDAO;
    private NoteViewModel noteViewModel = new NoteViewModel();
    private NoteView noteView;
    private NoteInteractor noteInteractor;

    /**
     * Sets the NoteDAO to be used in this application.
     * @param weatherDataAccess the DAO to use
     * @return this builder
     */
    public NoteAppBuilder addNoteDAO(WeatherDataAccessInterface weatherDataAccess) {
        noteDAO = weatherDataAccess;
        return this;
    }

    /**
     * Creates the objects for the Note Use Case and connects the NoteView to its
     * controller.
     * <p>This method must be called after addNoteView!</p>
     * @return this builder
     * @throws RuntimeException if this method is called before addNoteView
     */
    public NoteAppBuilder addNoteUseCase() {
        final NoteOutputBoundary noteOutputBoundary = new NotePresenter(noteViewModel);
        noteInteractor = new NoteInteractor(
                noteDAO, noteOutputBoundary);

        final NoteController controller = new NoteController(noteInteractor);
        if (noteView == null) {
            throw new RuntimeException("addNoteView must be called before addNoteUseCase");
        }
        noteView.setNoteController(controller);
        return this;
    }

    /**
     * Creates the NoteView and underlying NoteViewModel.
     * @return this builder
     */
    public NoteAppBuilder addNoteView() {
        noteViewModel = new NoteViewModel();
        noteView = new NoteView(noteViewModel);
        return this;
    }

    /**
     * Builds the application.
     * @return the JFrame for the application
     */
    public JFrame build() {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Note Application");
        frame.setSize(WIDTH, HEIGHT);

        frame.add(noteView);

        // refresh so that the note will be visible when we start the program
        noteInteractor.executeRefresh();

        return frame;

    }

    public NoteAppBuilder addSearchResultView() {
    }

    public NoteAppBuilder addSelectRegionView() {
        return null;
    }

    public NoteAppBuilder addNearbyListView() {
    }

    public NoteAppBuilder addPinWeatherView() {
    }

    public NoteAppBuilder addAlertPopView() {
    }

    public NoteAppBuilder addCityBookmarkView() {
    }

    public NoteAppBuilder addSearchResultUseCase() {
    }

    public NoteAppBuilder addSearchReturnUseCase() {
    }

    public NoteAppBuilder addSelectRegionUseCase() {
    }

    public NoteAppBuilder addNearbyListUseCase() {
    }

    public NoteAppBuilder addCloseListUseCase() {
    }

    public NoteAppBuilder addPinWeatherUseCase() {
    }

    public NoteAppBuilder addClosePinUseCase() {
    }

    public NoteAppBuilder addAlertPopUseCase() {
    }

    public NoteAppBuilder addClosePopUseCase() {
    }

    public NoteAppBuilder addBookmarkReturnCase() {
    }

    public NoteAppBuilder addCityBookmarkUseCase() {
        return null;
    }
}
