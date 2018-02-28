package uk.charliesay.VendingMachine.Display;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class ConsoleDisplayTest {

    private ConsoleDisplay testConsoleDisplay;

    @Before
    public void setUp(){
        testConsoleDisplay = new ConsoleDisplay();
    }

    @Test
    public void ShouldReturnBreakerLinesOnLineZeroAndThree_RegardlessOfInput(){
        String testString = "This is a Big Ting";
        String resultShouldBe = "=========================";

        String resultString = testConsoleDisplay.readInput(testString);
        String[] resultStringArray = resultString.split("\n");

        Assert.assertThat(resultStringArray[0],is(resultShouldBe));
        Assert.assertThat(resultStringArray[2],is(resultShouldBe));
    }

    @Test
    public void shouldReturnFormattedString_WhenRandomStringIsPassedIn(){
        String testString = "Test Object";
        String endResultString = "=========================\n" +
                                 "Test Object\n" +
                                 "=========================\n";

        String resultString = testConsoleDisplay.readInput(testString);

        Assert.assertEquals(endResultString,resultString);
    }

}