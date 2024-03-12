package server.modelinput;

import server.input.CurrentInputMode;
import server.input.EInputMode;
import client.MessageConstant;
import server.output.OutputManager;
import database.models.View;
import server.exceptions.ExitToMenuException;

/**
 * The class that is responsible for the View input
 */

public class ViewInput {
    public static View viewInput() throws ExitToMenuException {
        View view;

        OutputManager.stOutput(MessageConstant.VIEW_INPUT);

        String input;
        label:
        while (true){
            if (CurrentInputMode.hasNextLine()){
                input = CurrentInputMode.getNextLine();

                switch (input) {
                    case "q":
                        throw new ExitToMenuException(MessageConstant.EXIT_TO_MENU);
                    case "1":
                        view = View.STREET;
                        break label;
                    case "2":
                        view = View.YARD;
                        break label;
                    case "3":
                        view = View.PARK;
                        break label;
                    case "4":
                        view = View.NORMAL;
                        break label;
                    default:
                        OutputManager.stOutput("Unknown Command // Try again // " +
                                MessageConstant.VIEW_INPUT);
                        break;
                }
            }
            else {
                CurrentInputMode.mode = EInputMode.USER_MODE;
            }
        }
        return view;

    }
}
