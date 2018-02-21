package uk.charliesay.VendingMachine.Money;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneyStoreTest {

    private MoneyStore testMoneyStore;

    @Before
    public void setUp(){
        testMoneyStore = new MoneyStore();
    }

    @Test
    public void should_ReturnAnObject_WhenMoneyStoreConstructorIsCalled(){
        Assert.assertNotNull(testMoneyStore);
    }

    @Test
    public void should_HaveNoFunds_WhenConstructed(){
        BigDecimal shouldBe = BigDecimal.valueOf(0.00).setScale(2, RoundingMode.CEILING);
        BigDecimal resultOfCurrentAmount = testMoneyStore.getCurrentAmount();
        Assert.assertEquals(shouldBe,resultOfCurrentAmount);
    }

    @Test
    public void should_IncreaseCurrentAmount_WhenGiven50Pence(){
        BigDecimal amountToIncrease = BigDecimal.valueOf(0.50).setScale(2, RoundingMode.CEILING);

        testMoneyStore.addToStore(amountToIncrease);
        BigDecimal resultAfterIncrease = testMoneyStore.getCurrentAmount();

        Assert.assertEquals(amountToIncrease,resultAfterIncrease);
    }

    @Test
    public void should_IncreaseCurrentAmount_WhenGiven50Pence10Pence1Pound(){
        BigDecimal amountToIncrease50Pence = BigDecimal.valueOf(0.50).setScale(2, RoundingMode.CEILING);
        BigDecimal amountToIncrease10Pence = BigDecimal.valueOf(0.10).setScale(2, RoundingMode.CEILING);
        BigDecimal amountToIncrease1Pound = BigDecimal.valueOf(1.00).setScale(2, RoundingMode.CEILING);
        BigDecimal amountShouldBe = BigDecimal.valueOf(1.60).setScale(2, RoundingMode.CEILING);

        testMoneyStore.addToStore(amountToIncrease50Pence);
        testMoneyStore.addToStore(amountToIncrease10Pence);
        testMoneyStore.addToStore(amountToIncrease1Pound);
        BigDecimal resultAfterIncrease = testMoneyStore.getCurrentAmount();

        Assert.assertEquals(amountShouldBe,resultAfterIncrease);
    }

    @Test
    public void should_DecreaseCurrentAmount_WhenCurrentIs2PoundAndItemIs1Pound10Pence(){
        BigDecimal amountToIncrease = BigDecimal.valueOf(2.00).setScale(2, RoundingMode.CEILING);
        BigDecimal amountToDecrease = BigDecimal.valueOf(1.10).setScale(2, RoundingMode.CEILING);
        BigDecimal shouldBe = BigDecimal.valueOf(0.90).setScale(2, RoundingMode.CEILING);

        testMoneyStore.addToStore(amountToIncrease);
        testMoneyStore.removeFromStore(amountToDecrease);
        BigDecimal resultAfterDecrease = testMoneyStore.getCurrentAmount();

        Assert.assertEquals(shouldBe,resultAfterDecrease);
    }

    @Test
    public void should_ReturnStringFormattedWithPoundSignAndDecimals_WhenGivenAValue(){
        testMoneyStore.addToStore(BigDecimal.valueOf(3.52).setScale(2, RoundingMode.CEILING));

        String resultOfFormatting = testMoneyStore.getCurrentAmountFormattedAsString();
        String shouldBe = "£3.52";

        Assert.assertEquals(resultOfFormatting,shouldBe);
    }

    @After
    public void tearDown(){
        testMoneyStore = null;
    }

}