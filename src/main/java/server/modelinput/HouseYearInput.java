package server.modelinput;

import server.input.CurrentInputMode;
import server.input.EInputMode;
import server.output.OutputManager;
import server.exceptions.ExitToMenuException;
import server.validators.HouseYearValidator;

/**
 * The class that is responsible for the House year input
 *
 * @since 1.0
 * @author savadanko
 */
public class HouseYearInput {
    public static long input() throws ExitToMenuException {
        long year;
        String input;
        OutputManager.stOutput("Enter House `year` or `q` for exit to menu");
        while (true){
            if (CurrentInputMode.hasNextLine()){
                input = CurrentInputMode.getNextLine();
                if (input.equals("q")){
                    throw new ExitToMenuException("Exit to menu");
                }
                else if(HouseYearValidator.validator(input)){
                    break;
                }
            }
            else {
                CurrentInputMode.mode = EInputMode.USER_MODE;
            }
        }
        year = Long.parseLong(input);
        return year;
    }
}
