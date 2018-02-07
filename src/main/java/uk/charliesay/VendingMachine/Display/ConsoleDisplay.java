package uk.charliesay.VendingMachine.Display;

public class ConsoleDisplay extends DisplayType {

    private final String BREAKER_LINE = "=========================\n";

    @Override
    public String ReadInput(String contentToRead) {
        String inputStringBuilder = "";
        inputStringBuilder += (BREAKER_LINE);
        inputStringBuilder += (contentToRead + "\n");
        inputStringBuilder += (BREAKER_LINE);
        OutputContent(inputStringBuilder);
        return inputStringBuilder;
    }

    @Override
    public void OutputContent(String contentToOutput) {
        System.out.println(contentToOutput);
    }
}
