package database;

import java.util.UUID;

/**
 * The class that is responsible for implementing unique IDs
 *
 * @since 1.0
 * @author savadanko
 */

public class IdGenerator {

    /**
     * A function that generates unique IDs
     * @return id
     */
        public static long generateId() {
            CollectionDataBase dataBase = CollectionDataBase.getDataBaseInstance();
            long uuid = UUID.randomUUID().getLeastSignificantBits();
            while (dataBase.getDataBase().containsKey(Long.parseLong(Long.toString(uuid)))){
                uuid = UUID.randomUUID().getLeastSignificantBits();
            }
            return Math.abs(Long.parseLong(Long.toString(uuid)));
    }
}