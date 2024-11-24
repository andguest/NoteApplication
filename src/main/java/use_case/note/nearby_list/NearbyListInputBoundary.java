package use_case.note.nearby_list;

/**
 * An input is when the map moves.
 */
public interface NearbyListInputBoundary {

    /**
     * Executes the nearby list use case.
     *
     * @param nearbyListInputData the input data for the nearby list use case.
     */
    void execute(NearbyListInputData nearbyListInputData);
}
