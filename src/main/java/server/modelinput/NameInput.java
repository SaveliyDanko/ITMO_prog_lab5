package server.modelinput;

import server.input.CurrentInputMode;
import server.input.EInputMode;
import client.MessageConstant;
import server.output.OutputManager;
import server.exceptions.ExitToMenuException;
import server.validators.NameValidator;

/**
 * The class that is responsible for the name input
 *
 * @since 1.0
 * @author savadanko
 */
public class NameInput {
    public static String flat() throws ExitToMenuException {
            String name;
            OutputManager.stOutput("Enter Flat name or `q` for exit to menu");
            while (true){
                if (CurrentInputMode.hasNextLine()){
                    name = CurrentInputMode.getNextLine();
                    if (name.equals("q")){
                        throw new ExitToMenuException(MessageConstant.EXIT_TO_MENU);
                    }
                    else if(NameValidator.validate(name)){
                        break;
                    }
                }
                else {
                    CurrentInputMode.mode = EInputMode.USER_MODE;
                }
            }
            return name;
    }

    public static String house() throws ExitToMenuException{
        String name;
        OutputManager.stOutput("Enter House name or `q` for exit to menu");
        while (true){
            if (CurrentInputMode.hasNextLine()){
                name = CurrentInputMode.getNextLine();
                if (name.equals("q")){
                    throw new ExitToMenuException(MessageConstant.EXIT_TO_MENU);
                } else if (name.equals("null")) {
                    name = null;
                    break;
                } else if(NameValidator.validate(name)){
                    break;
                }
            }
            else {
                CurrentInputMode.mode = EInputMode.USER_MODE;
            }
        }
        return name;
    }
}
