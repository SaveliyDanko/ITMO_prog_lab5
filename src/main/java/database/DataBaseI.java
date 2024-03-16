package database;

import database.models.Flat;

import java.util.LinkedHashMap;

/**
 * Interface for database implementation
 *
 * @since 1.0
 * @author savadanko
 */

public interface DataBaseI{
    LinkedHashMap<Long, Flat> getDataBase();

    /**
     * Dara Base help information
     */
    void help(String[] args);

    /**
     * Dara Base info information
     */
    void info(String[] args);

    /**
     * Dara Base show information
     */
    void show(String[] args);
}
