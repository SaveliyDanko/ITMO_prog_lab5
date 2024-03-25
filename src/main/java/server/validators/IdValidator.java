package server.validators;

/**
 * A class for implementing the ID validator
 *
 * @since 1.0
 * @author savadanko
 */
public class IdValidator {
    public static boolean validator(String id){
        if (id.isEmpty()){
            return false;
        }
        try{
            Long.parseLong(id);
        }
        catch (NumberFormatException e){
            return false;
        }
        return Long.parseLong(id) > 0;
    }
}
