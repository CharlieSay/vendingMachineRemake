package uk.charliesay.VendingMachine.Display;

public abstract class Display {

    abstract String readInput(String contentToRead);
    abstract void outputContent(String contentToOutput);

}
