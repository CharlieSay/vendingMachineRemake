package uk.charliesay.VendingMachine.Display;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConsoleDisplayTest {

    private ConsoleDisplay consoleDisplay;

    @Before
    public void setUp(){
        consoleDisplay = new ConsoleDisplay();
    }

    @Test
    public void shouldReturnFormattedString_WhenRandomStringIsPassedIn(){
        String testString = "Test Object";
        String endResultString = "=========================\n" +
                                 "Test Object\n" +
                                 "=========================\n";

        String resultString = consoleDisplay.ReadInput(testString);

        Assert.assertEquals(endResultString,resultString);
    }

}