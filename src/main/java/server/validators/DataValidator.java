package server.validators;


/**
 * A class for implementing the data validator
 */
public class DataValidator {
    public static boolean validator(String data){
        String[] dataSplit = data.split("-");
        if (dataSplit.length == 5){
            for (String i : dataSplit){
                try{
                    Integer.parseInt(i);
                }
                catch (NumberFormatException e){
                    //System.out.println("here");
                    return  false;
                }
            }
            return true;
        }
        else {
            System.out.println("here");
            return false;
        }
    }
}
