package use_case.note.nearby_cities;

/**
 * An input is when the map moves.
 */
public interface NearbyCitiesInputBoundary {

    /**
     * Executes the nearby list use case.
     *
     * @param nearbyCitiesInputData the input data for the nearby list use case.
     */
    void execute(NearbyCitiesInputData nearbyCitiesInputData);
}
