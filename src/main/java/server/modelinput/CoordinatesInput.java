package server.modelinput;

import database.models.Coordinates;
import server.exceptions.ExitToMenuException;

/**
 * The class that is responsible for the Coordinates input
 *
 * @since 1.0
 * @author savadanko
 */

public class CoordinatesInput {
    public static Coordinates input() throws ExitToMenuException {
        float x = XCoordinateInput.input();
        Long y = YCoordinateInput.input();
        return new Coordinates(x, y);
    }
}
