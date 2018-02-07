package uk.charliesay.VendingMachine.Display;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OledDisplayTest {

    private OledDisplay testOledDisplayObject;

    @Before
    public void setup(){
        testOledDisplayObject = new OledDisplay();
    }

    @Test
    public void should_ReturnStringFormattedWithSymbols_WhenGivenString(){
        String currentMoney = "Released Cheddars - £1 Left";
        String shouldBe = "><><><><><><><><><><><><><\n"+
                "> Released Cheddars - £1 Left\n" +
                "><><><><><><><><><><><><><\n";

        String testResult = testOledDisplayObject.ReadInput(currentMoney);

        Assert.assertEquals(shouldBe,testResult);
    }

    @Test
    public void should_ReturnDeatchedState_WhenNothingGoesWrong(){
        DetachableStates detachableStatesShouldBe = DetachableStates.DETACHED;
        DetachableStates testResult = testOledDisplayObject.detach();

        Assert.assertEquals(detachableStatesShouldBe,testResult);
    }
}