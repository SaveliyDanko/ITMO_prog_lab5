package server.modelinput;


import database.models.House;
import server.exceptions.ExitToMenuException;

/**
 * The class that is responsible for the House input
 */
public class HouseInput {
    public static House houseInput() throws ExitToMenuException {

        String name = NameInput.house();

        Long year = HouseYearInput.input();

        Long numberOfFloors = HouseNumberOfFloorsInput.input();

        int numberOfFlatsOnFloor = HouseNumberOfFlatsOnFloorInput.input();

        int numberOfLifts = HouseNumberOfLiftsInput.input();

        return new House(name, year, numberOfFloors, numberOfFlatsOnFloor, numberOfLifts);
    }
}
