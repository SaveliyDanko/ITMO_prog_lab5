package database;

import database.models.Flat;

import java.util.LinkedHashMap;

/**
 * Interface for database implementation
 */

public interface DataBaseI{
    LinkedHashMap<Long, Flat> getDataBase();

    /**
     * Dara Base help information
     */
    void help();

    /**
     * Dara Base info information
     */
    void info();

    /**
     * Dara Base show information
     */
    void show();
}
