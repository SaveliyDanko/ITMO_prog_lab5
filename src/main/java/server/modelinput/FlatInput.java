package server.modelinput;

import database.models.*;
import server.exceptions.ExitToMenuException;

/**
 * The class that is responsible for the Flat input
 *
 * @since 1.0
 * @author savadanko
 */
public class FlatInput{
    public static Flat input() throws ExitToMenuException {
        String name = NameInput.flat();

        Coordinates coordinates = CoordinatesInput.input();

        float area = AreaInput.input();

        Long numberOfRooms = FlatNumberOfRoomsInput.input();

        Float price = FlatPriceInput.input();

        View view = ViewInput.viewInput();
        Transport transport = TransportInput.transportInput();

        House house = HouseInput.houseInput();

        return new Flat(name, coordinates, area, numberOfRooms, price, view, transport, house);
    }
}
