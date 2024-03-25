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
            UUID uuid = UUID.randomUUID();
            while (dataBase.getDataBase().containsKey(Long.parseLong(uuid.toString()))){
                uuid = UUID.randomUUID();
            }
            return Long.parseLong(uuid.toString());
    }
}