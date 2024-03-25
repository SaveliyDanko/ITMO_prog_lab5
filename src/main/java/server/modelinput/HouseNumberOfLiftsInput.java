package server.modelinput;

import server.input.CurrentInputMode;
import server.input.EInputMode;
import server.output.OutputManager;
import server.exceptions.ExitToMenuException;
import server.validators.HouseNumberOfLiftsValidator;

/**
 * The class that is responsible for the House number of lifts input
 *
 * @since 1.0
 * @author savadanko
 */
public class HouseNumberOfLiftsInput {
    public static Integer input() throws ExitToMenuException {
        int numberOfLifts;
        String input;
        OutputManager.stOutput("Enter House `numberOfLifts` or `q` for exit to menu");
        while (true){
            if (CurrentInputMode.hasNextLine()){
                input = CurrentInputMode.getNextLine();
                if (input.equals("q")){
                    throw new ExitToMenuException("Exit to menu");
                }
                else if(HouseNumberOfLiftsValidator.validator(input)){
                    break;
                }
            }
            else {
                CurrentInputMode.mode = EInputMode.USER_MODE;
            }
        }
        numberOfLifts = Integer.parseInt(input);
        return numberOfLifts;
    }
}
