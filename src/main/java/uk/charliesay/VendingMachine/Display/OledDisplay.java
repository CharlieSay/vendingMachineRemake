package uk.charliesay.VendingMachine.Display;

import uk.charliesay.VendingMachine.Exceptions.InDetachmentException;


public class OledDisplay extends Display implements Detachable {

    /*
    Foobar here is a FAKE Detachment code, pretending to be some "physical movement"
     */
    public boolean detachScreen(String inputDetachCode) throws InDetachmentException {
        String detachCode = "FooBar";
        if (detachCode.equalsIgnoreCase(inputDetachCode)){
                return true;
            }else{
                throw new InDetachmentException("Something went wrong with screen detach.");
            }

    }

    @Override
    public String readInput(String contentToRead) {
        String oledContentFormatted = "";
        oledContentFormatted += "><><><><><><><><><><><><><\n";
        oledContentFormatted += "> "+ contentToRead + "\n";
        oledContentFormatted += "><><><><><><><><><><><><><\n";
        return oledContentFormatted;
    }

    @Override
    public void outputContent(String contentToOutput) {
        System.out.println(readInput(contentToOutput));
    }
}
