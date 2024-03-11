package database.models;

import java.io.Serial;
import java.io.Serializable;

/**
 * House class
 */

public class House implements Serializable {

    /**
     * serialVersionUID value
     */
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * name value
     */
    private final String name; //Поле может быть null

    /**
     * year value
     */
    private final Long year; //Значение поля должно быть больше 0

    /**
     * numberOfFloors value
     */

    private final Long numberOfFloors; //Значение поля должно быть больше 0

    /**
     * numberOfFlatsOnFloor value
     */
    private final int numberOfFlatsOnFloor; //Значение поля должно быть больше 0

    /**
     * number of Lists value
     */
    private final int numberOfLifts; //Значение поля должно быть больше 0

    /**
     * get name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * get year
     * @return year
     */
    public Long getYear() {
        return year;
    }

    /**
     * get getNumberOfFloors
     * @return getNumberOfFloors
     */
    public Long getNumberOfFloors() {
        return numberOfFloors;
    }

    /**
     * get getNumberOfFlatsOnFloor
     * @return getNumberOfFlatsOnFloor
     */
    public int getNumberOfFlatsOnFloor() {
        return numberOfFlatsOnFloor;
    }

    /**
     * get getNumberOfLifts
     * @return getNumberOfLifts
     */
    public int getNumberOfLifts() {
        return numberOfLifts;
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", numberOfFloors=" + numberOfFloors +
                ", numberOfFlatsOnFloor=" + numberOfFlatsOnFloor +
                ", numberOfLifts=" + numberOfLifts +
                '}';
    }

    public House(String name, Long year, Long numberOfFloors, int numberOfFlatsOnFloor, int numberOfLifts) {
        if (year <= 0 || numberOfFloors <= 0 || numberOfFlatsOnFloor <= 0 || numberOfLifts <= 0) {
            throw new IllegalArgumentException("Invalid parameter value.");
        }
        this.name = name;
        this.year = year;
        this.numberOfFloors = numberOfFloors;
        this.numberOfFlatsOnFloor = numberOfFlatsOnFloor;
        this.numberOfLifts = numberOfLifts;
    }

}
