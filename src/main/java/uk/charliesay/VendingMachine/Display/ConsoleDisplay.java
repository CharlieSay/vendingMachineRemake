package uk.charliesay.VendingMachine.Display;

public class ConsoleDisplay extends Display {

    private final String BREAKER_LINE = "=========================\n";

    @Override
    public String readInput(String contentToRead) {
        String inputStringBuilder = "";
        inputStringBuilder += (BREAKER_LINE);
        inputStringBuilder += (contentToRead + "\n");
        inputStringBuilder += (BREAKER_LINE);
        outputContent(inputStringBuilder);
        return inputStringBuilder;
    }

    @Override
    public void outputContent(String contentToOutput) {
        System.out.println(contentToOutput);
    }
}
