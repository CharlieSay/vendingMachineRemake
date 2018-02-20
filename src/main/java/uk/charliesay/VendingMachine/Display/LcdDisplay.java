package uk.charliesay.VendingMachine.Display;

public class LcdDisplay extends Display {

    @Override
    String ReadInput(String contentToRead) {
        String LCD_Format = matchDisplayBordersToContent(contentToRead);
        String lcdContentFormatted = "";
        lcdContentFormatted += LCD_Format + "\n";
        lcdContentFormatted += "x+ "+ contentToRead + " x+\n";
        lcdContentFormatted += LCD_Format + "\n";
        return lcdContentFormatted;
    }

    @Override
    void OutputContent(String contentToOutput) {
        System.out.println(ReadInput(contentToOutput));
    }

    /*
    This is purely for aesthetic reasoning, it will take the String length,
    Then put it into a "text" box and fully contain it.
     */

    private String matchDisplayBordersToContent(String contentToMatch){
        String returnLCDStringLength = "";
        for (int i = 0; i<contentToMatch.length()/2; i++){
            returnLCDStringLength += "x+";
        }
        returnLCDStringLength += "x+x+x+";
        return returnLCDStringLength;
    }
}
