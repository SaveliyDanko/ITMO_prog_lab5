package database;

import database.models.Flat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;

/**
 * The class that is responsible for implementing the database
 *
 * @since 1.0
 * @author savadanko
 */

public class CollectionDataBase implements DataBaseI{

    /**
     * A collection that contains objects
     */
    private final LinkedHashMap<Long, Flat> collection = new LinkedHashMap<>();

    /**
     * Date and Time initialization
     */
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
    LocalDateTime now = LocalDateTime.now();
    public String initializationTime = now.format(formatter);

    // Singleton realization
    private static final CollectionDataBase dataBaseInstance = new CollectionDataBase();
    private CollectionDataBase() {}
    public static CollectionDataBase getDataBaseInstance() {
        return dataBaseInstance;
    }

    /**
     * get collection
     * @return collection
     */
    public LinkedHashMap<Long, Flat> getDataBase() {
        return collection;
    }
}
