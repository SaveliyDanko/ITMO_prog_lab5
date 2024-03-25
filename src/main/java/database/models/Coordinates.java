package database.models;

import java.io.Serial;
import java.io.Serializable;

/**
 * Coordinates(x,y) of flat.
 */

public class Coordinates implements Serializable {
    /**
     * serialVersionUID value
     */
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * x value
     */
    private final float x; //Максимальное значение поля: 155

    /**
     * y value
     */
    private final Long y; //Значение поля должно быть больше -694, Поле не может быть null

    /**
     * getter for x
     * @return x
     */
    public float getX() {
        return x;
    }

    /**
     * getter for y
     * @return y
     */
    public Long getY() {
        return y;
    }

    public Coordinates(float x, Long y) {
        if (x > 155) throw new IllegalArgumentException("x value is too big.");
        if (y == null || y <= -694) throw new IllegalArgumentException("Invalid y value.");
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
