package server.validators;

import java.util.ArrayList;
import java.util.List;

/**
 * A class for implementing the view validator
 *
 * @since 1.0
 * @author savadanko
 */
public class ViewValidator {
    public static boolean validator(String line){
        List<String> viewArray = new ArrayList<>();
        viewArray.add("STREET");
        viewArray.add("YARD");
        viewArray.add("PARK");
        viewArray.add("NORMAL");
        return viewArray.contains(line);
    }
}
