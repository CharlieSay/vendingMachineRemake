package uk.charliesay.VendingMachine.Display;

import uk.charliesay.VendingMachine.Exceptions.InDetachmentException;


public class OledDisplay extends DisplayType implements Detachable {

    public boolean detachScreen(String inputDetachCode) throws InDetachmentException {
            String detachCode = "FooBar";
            if (detachCode.equalsIgnoreCase(inputDetachCode)){
                //Pretend Case "as if there was some deatchment code";
                return true;
            }else{
                throw new InDetachmentException("Something went wrong with screen detach.");
            }

    }

    @Override
    String ReadInput(String contentToRead) {
        String oledContentFormatted = "";
        oledContentFormatted += "><><><><><><><><><><><><><\n";
        oledContentFormatted += "> "+ contentToRead + "\n";
        oledContentFormatted += "><><><><><><><><><><><><><\n";
        return oledContentFormatted;
    }

    @Override
    void OutputContent(String contentToOutput) {
        System.out.println(ReadInput(contentToOutput));
    }
}
