package uk.charliesay.VendingMachine.Display;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.charliesay.VendingMachine.Exceptions.InDetachmentException;

public class OledDisplayTest {

    private OledDisplay testOledDisplayObject;

    @Before
    public void setup(){
        testOledDisplayObject = new OledDisplay();
    }

    @Test
    public void should_ReturnStringFormattedWithSymbols_WhenGivenString(){
        String testSubject = "Released Cheddars - £1 Left";
        String shouldBe = "><><><><><><><><><><><><><\n"+
                          "> Released Cheddars - £1 Left\n" +
                          "><><><><><><><><><><><><><\n";

        String testResult = testOledDisplayObject.readInput(testSubject);

        Assert.assertEquals(shouldBe,testResult);
    }

    @Test(expected = InDetachmentException.class)
    public void should_ThrowIDException_WhenWrongDetachCodeIsGiven() throws InDetachmentException {
        testOledDisplayObject.detachScreen("BooFar");
    }

    @Test
    public void should_AllowDetachment_WhenCorrectCodeIsGiven() throws InDetachmentException {
        boolean result = testOledDisplayObject.detachScreen("FooBar");
        Assert.assertTrue(result);
    }
}