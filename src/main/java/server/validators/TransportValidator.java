package server.validators;

import java.util.ArrayList;
import java.util.List;

/**
 * A class for implementing the transport validator
 */
public class TransportValidator {
    public static boolean validate(String line){
        List<String> transportArray = new ArrayList<>();
        transportArray.add("FEW");
        transportArray.add("NONE");
        transportArray.add("LITTLE");
        transportArray.add("NORMAL");
        return transportArray.contains(line);
    }
}
