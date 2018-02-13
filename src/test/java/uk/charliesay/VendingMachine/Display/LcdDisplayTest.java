package uk.charliesay.VendingMachine.Display;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class LcdDisplayTest {

    private LcdDisplay testLcdDisplayObject;

    @Before
    public void setup(){
        testLcdDisplayObject = new LcdDisplay();
    }

    @Test
    public void should_ReturnStringFormattedWithBars_WhenGivenString24Characters(){
        String currentMoney = "Released Yacht - £1 Left";
        String shouldBe = "x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+\n"+
                          "x+ Released Yacht - £1 Left x+\n" +
                          "x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+\n";

        String methodReturn = testLcdDisplayObject.ReadInput(currentMoney);

        Assert.assertThat(methodReturn,is(shouldBe));

    }

    @Test
    public void should_ReturnStringFormattedWithBars_WhenGivenString10Characters(){
        String currentMoney = "BleepBloop";
        String shouldBe = "x+x+x+x+x+x+x+x+\n"+
                          "x+ BleepBloop x+\n" +
                          "x+x+x+x+x+x+x+x+\n";

        String methodReturn = testLcdDisplayObject.ReadInput(currentMoney);

        Assert.assertThat(methodReturn,is(shouldBe));

    }

}