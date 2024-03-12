package server.modelinput;

import server.input.CurrentInputMode;
import server.input.EInputMode;
import client.MessageConstant;
import server.output.OutputManager;
import server.exceptions.ExitToMenuException;
import server.validators.FlatPriceValidator;

/**
 * The class that is responsible for the flat price input
 */
public class FlatPriceInput {
    public static Float input() throws ExitToMenuException {
        float price;
        String input;
        OutputManager.stOutput("Enter Flat `price` or `q` for exit to menu");
        while (true) {
            if (CurrentInputMode.hasNextLine()) {
                input = CurrentInputMode.getNextLine();
                if (input.equals("q")) {
                    throw new ExitToMenuException(MessageConstant.EXIT_TO_MENU);
                } else if (FlatPriceValidator.validator(input)) {
                    break;
                }
            } else {
                CurrentInputMode.mode = EInputMode.USER_MODE;
            }
        }
        price = Float.parseFloat(input);
        return price;
    }
}
