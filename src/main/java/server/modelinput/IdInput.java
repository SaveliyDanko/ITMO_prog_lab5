package server.modelinput;

import server.input.CurrentInputMode;
import server.input.EInputMode;
import client.MessageConstant;
import server.output.OutputManager;
import server.exceptions.ExitToMenuException;
import server.validators.IdValidator;

/**
 * The class that is responsible for the id input
 *
 * @since 1.0
 * @author savadanko
 */
public class IdInput {
    public static Long idInput() throws ExitToMenuException{
        OutputManager.stOutput("Input ID or `q` for exit to menu");

        String input;
        long id;
        while (true){
            if (CurrentInputMode.hasNextLine()){
                input = CurrentInputMode.getNextLine();

                if (input.equals("q")){
                    throw new ExitToMenuException(MessageConstant.EXIT_TO_MENU);
                }
                else if(IdValidator.validator(input)){
                    break;
                }
            }
            else {
                CurrentInputMode.mode = EInputMode.USER_MODE;
            }
        }
        id = Long.parseLong(input);
        return id;
    }
}
