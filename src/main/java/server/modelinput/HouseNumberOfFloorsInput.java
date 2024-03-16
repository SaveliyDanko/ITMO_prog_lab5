package server.modelinput;

import server.input.CurrentInputMode;
import server.input.EInputMode;
import client.MessageConstant;
import server.output.OutputManager;
import server.exceptions.ExitToMenuException;
import server.validators.HouseNumberOfFloorsValidator;

/**
 * The class that is responsible for the House number of floors input
 *
 * @since 1.0
 * @author savadanko
 */
public class HouseNumberOfFloorsInput {
    public static long input() throws ExitToMenuException {
        long numberOfFloors;
        String input;
        OutputManager.stOutput("Enter House `numberOfFloors` or `q` for exit to menu");
        while (true){
            if (CurrentInputMode.hasNextLine()){
                input = CurrentInputMode.getNextLine();
                if (input.equals("q")){
                    throw new ExitToMenuException(MessageConstant.EXIT_TO_MENU);
                }
                else if(HouseNumberOfFloorsValidator.validator(input)){
                    break;
                }
            }
            else {
                CurrentInputMode.mode = EInputMode.USER_MODE;
            }
        }
        numberOfFloors = Long.parseLong(input);
        return numberOfFloors;
    }
}
