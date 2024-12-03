package use_case.note;

import data_access.NearbyCitiesAccessObject;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import use_case.note.nearby_cities.*;

public class NearbyCitiesInteractorTest {
    private NearbyCitiesAccessInterface cityDAO;
    private NearbyCitiesOutputBoundary cityOB;

    @Test
    public void testCorrectList() {
        final NearbyCitiesInputData torontoInput = new NearbyCitiesInputData(-79.4163, 43.70011);

        cityDAO = new NearbyCitiesAccessObject();

        cityOB = new NearbyCitiesOutputBoundary() {
            @Override
            public void presentSuccessView(NearbyCitiesOutputData nearbyListOutputData) {
                String[] citiesNearToronto = {"Chicago", "Montreal", "New York", "Ottawa", "Philadelphia", "Washington"};
                Assertions.assertArrayEquals(citiesNearToronto, nearbyListOutputData.getCities());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                Assertions.fail();
            }
        };

        NearbyCitiesInteractor cityInteractor = new NearbyCitiesInteractor(cityOB, cityDAO);
        cityInteractor.execute(torontoInput);
    }

    @Test
    public void testInvalidInput () {
        final NearbyCitiesInputData badInput  = new NearbyCitiesInputData(1000, 10);

        cityDAO = new NearbyCitiesAccessObject();

        cityOB = new NearbyCitiesOutputBoundary() {
            @Override
            public void presentSuccessView(NearbyCitiesOutputData nearbyListOutputData) {
                Assertions.fail();
            }

            @Override
            public void prepareFailView(String errorMessage) {
                Assertions.assertEquals("Error: Invalid input", errorMessage);
            }
        };

        NearbyCitiesInteractor cityInteractor = new NearbyCitiesInteractor(cityOB, cityDAO);
        cityInteractor.execute(badInput);
    }
}
