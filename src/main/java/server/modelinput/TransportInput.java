package server.modelinput;

import server.input.InputManager;
import server.input.EInputMode;
import client.MessageConstant;
import server.output.OutputManager;
import database.models.Transport;
import server.exceptions.ExitToMenuException;

/**
 * The class that is responsible for the Transport input
 *
 * @since 1.0
 * @author savadanko
 */
public class TransportInput {
    public static Transport transportInput() throws ExitToMenuException {
        Transport transport;

        OutputManager.stOutput(MessageConstant.TRANSPORT_INPUT);

        String input;
        label:
        while (true){
            if (InputManager.hasNextLine()){
                input = InputManager.getNextLine();

                switch (input) {
                    case "q":
                        throw new ExitToMenuException(MessageConstant.EXIT_TO_MENU);
                    case "1":
                        transport = Transport.FEW;
                        break label;
                    case "2":
                        transport = Transport.NONE;
                        break label;
                    case "3":
                        transport = Transport.LITTLE;
                        break label;
                    case "4":
                        transport = Transport.NORMAL;
                        break label;
                    case "5":
                        transport = null;
                        break label;
                    default:
                        OutputManager.stOutput("Unknown Command // Try again // " +
                                MessageConstant.TRANSPORT_INPUT);

                }
            }
            else {
                InputManager.mode = EInputMode.USER_MODE;
            }
        }
        return transport;

    }
}
