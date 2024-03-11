package database.models;

import database.IdGenerator;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Flat class
 */

public class Flat implements Comparable<Flat>, Serializable {

    /**
     * serialVersionUID value
     */
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id value
     */
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически

    /**
     * name value
     */
    private final String name; //Поле не может быть null, Строка не может быть пустой

    /**
     * Coordinates value
     */
    private final Coordinates coordinates; //Поле не может быть null

    /**
     * creationDate value
     */
    private String creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    /**
     * area value
     */
    private final float area; //Значение поля должно быть больше 0

    /**
     * numberOfRooms value
     */
    private final long numberOfRooms; //Значение поля должно быть больше 0

    /**
     * price value
     */
    private final Float price; //Значение поля должно быть больше 0

    /**
     * view value
     */
    private final View view; //Поле может быть null

    /**
     * Transport value
     */
    private final Transport transport; //Поле не может быть null

    /**
     * House value
     */
    private final House house; //Поле не может быть null

    // automatic generate id

    public Flat(String name, Coordinates coordinates, float area, long numberOfRooms, Float price,
                View view, Transport transport, House house) {
        if (name == null || name.isEmpty() || area <= 0 || numberOfRooms <= 0 || price <= 0 || transport == null || house == null) {
            throw new IllegalArgumentException("Invalid parameter value.");
        }
        this.id = IdGenerator.generateUniqueId();
        this.name = name;
        this.coordinates = coordinates;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
        LocalDateTime now = LocalDateTime.now();
        this.creationDate = now.format(formatter);
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.price = price;
        this.view = view;
        this.transport = transport;
        this.house = house;
    }


    /**
     * set ID
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * set creation date
     */
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * get id
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * get name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * get coordinates
     * @return Coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * get creation date
     * @return creationDate
     */
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * get area
     * @return area
     */
    public float getArea() {
        return area;
    }

    /**
     * get number of rooms
     * @return numberOfRooms
     */
    public long getNumberOfRooms() {
        return numberOfRooms;
    }

    /**
     * get price
     * @return price
     */
    public Float getPrice() {
        return price;
    }

    /**
     * get View
     * @return View
     */
    public View getView() {
        return view;
    }

    /**
     * get Transport
     * @return Transport
     */
    public Transport getTransport() {
        return transport;
    }

    /**
     * get House
     * @return House
     */
    public House getHouse() {
        return house;
    }

    /**
     * Compare by price
     * @param f the object to be compared.
     * @return int
     */
    @Override
    public int compareTo(Flat f) {
        return (int) (this.price - f.price);
    }

    @Override
    public String toString() {
        return "Flat{" +
                "name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", area=" + area +
                ", numberOfRooms=" + numberOfRooms +
                ", price=" + price +
                ", view=" + view +
                ", transport=" + transport +
                ", house=" + house +
                '}';
    }
}
