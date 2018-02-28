package uk.charliesay.VendingMachine.Display;

import uk.charliesay.VendingMachine.Exceptions.InDetachmentException;


public class OledDisplay extends Display implements Detachable {

    public boolean detachScreen(String inputDetachCode) throws InDetachmentException {
        //Pretend Case "as if there was some deatchment code";
        String detachCode = "FooBar";
        if (detachCode.equalsIgnoreCase(inputDetachCode)){
                return true;
            }else{
                throw new InDetachmentException("Something went wrong with screen detach.");
            }

    }

    @Override
    String readInput(String contentToRead) {
        String oledContentFormatted = "";
        oledContentFormatted += "><><><><><><><><><><><><><\n";
        oledContentFormatted += "> "+ contentToRead + "\n";
        oledContentFormatted += "><><><><><><><><><><><><><\n";
        return oledContentFormatted;
    }

    @Override
    void outputContent(String contentToOutput) {
        System.out.println(readInput(contentToOutput));
    }
}
