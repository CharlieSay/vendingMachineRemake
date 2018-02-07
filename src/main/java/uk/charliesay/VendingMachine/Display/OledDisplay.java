package uk.charliesay.VendingMachine.Display;

import uk.charliesay.VendingMachine.Exceptions.InDetachmentException;

import static uk.charliesay.VendingMachine.Display.DetachableStates.*;

public class OledDisplay extends DisplayType implements Detachable {

    public DetachableStates detach() {
        try {
            if (true){
                return DETACHED;
            }else{
                throw new InDetachmentException("Something went wrong with screen detach.");
            }
        } catch (InDetachmentException e) {
            return ERROR_INDEATCH;
        } catch (Exception e){
            return UNKNOWN_ERROR;
        }
    }

    @Override
    String ReadInput(String contentToRead) {
        String oledContentFormatted = "";
        oledContentFormatted += "><><><><><><><><><><><><><\n";
        oledContentFormatted += "> "+contentToRead+"\n";
        oledContentFormatted += "><><><><><><><><><><><><><\n";
        return oledContentFormatted;
    }

    @Override
    void OutputContent(String contentToOutput) {
        System.out.println(ReadInput(contentToOutput));
    }
}
