package uk.charliesay.VendingMachine.Display;

public abstract class DisplayType {

    abstract String ReadInput(String contentToRead);
    abstract void OutputContent(String contentToOutput);

}
