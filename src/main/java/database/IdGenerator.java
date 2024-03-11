package database;

import java.util.Random;
import java.util.Set;

/**
 * The class that is responsible for implementing unique IDs
 */

public class IdGenerator {

    /**
     * A function that generates unique IDs
     * @return id
     */
    public static long generateUniqueId() {
        DataBaseI dataBase = CollectionDataBase.getDataBaseInstance();
        Set<Long> existingIds = dataBase.getDataBase().keySet();
        Random random = new Random();
        long id;

        if (existingIds.isEmpty()) {
            id = Math.abs(random.nextLong());
        } else {
            do {
                id = Math.abs(random.nextLong());
            } while (existingIds.contains(id));
        }
        return id;
    }
}