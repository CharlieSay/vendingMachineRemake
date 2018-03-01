package uk.charliesay.VendingMachine.Display;

public class LcdDisplay extends Display {

    @Override
    public String readInput(String contentToRead) {
        String LCD_Format = matchDisplayBordersToContent(contentToRead);
        String lcdContentFormatted = "";
        lcdContentFormatted += LCD_Format + "\n";
        lcdContentFormatted += "x+ "+ contentToRead + " x+\n";
        lcdContentFormatted += LCD_Format + "\n";
        return lcdContentFormatted;
    }

    @Override
    public void outputContent(String contentToOutput) {
        System.out.println(readInput(contentToOutput));
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
