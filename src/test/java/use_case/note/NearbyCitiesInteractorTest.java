package use_case.note;

import org.junit.Test;
import use_case.note.nearby_cities.*;

import java.io.IOException;
import java.util.List;

public class NearbyCitiesInteractorTest {

    @Test
    public void testOutput() {
        NearbyCitiesAccessInterface cityDAO = new NearbyCitiesAccessInterface() {
            @Override
            public List<String> getNearbyCities(double latitude, double longitude) throws IOException {
                return List.of();
            }
        };

        NearbyCitiesOutputBoundary cityOB = new NearbyCitiesOutputBoundary() {
            @Override
            public void presentSuccessView(NearbyCitiesOutputData nearbyListOutputData) {

            }

            @Override
            public void prepareFailView(String errorMessage) {

            }
        };

        NearbyCitiesInteractor cityInteractor = new NearbyCitiesInteractor(cityOB, cityDAO);
        NearbyCitiesInputData input = new NearbyCitiesInputData(0.0, 0.0);
        cityInteractor.execute(input);
    }
}
