package uk.charliesay.VendingMachine.Money;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

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
        BigDecimal shouldBe = BigDecimal.valueOf(0);
        BigDecimal resultOfCurrentAmount = testMoneyStore.getCurrentAmount();
        Assert.assertEquals(shouldBe,resultOfCurrentAmount);
    }

    @Test
    public void should_IncreaseCurrentAmount_WhenGiven50Pence(){
        BigDecimal amountToIncrease = BigDecimal.valueOf(0.50);

        testMoneyStore.addToStore(amountToIncrease);
        BigDecimal resultAfterIncrease = testMoneyStore.getCurrentAmount();

        Assert.assertEquals(amountToIncrease,resultAfterIncrease);
    }

    @Test
    public void should_IncreaseCurrentAmount_WhenGiven50Pence10Pence1Pound(){
        BigDecimal amountToIncrease50Pence = BigDecimal.valueOf(0.50);
        BigDecimal amountToIncrease10Pence = BigDecimal.valueOf(0.10);
        BigDecimal amountToIncrease1Pound = BigDecimal.valueOf(1.00);
        BigDecimal amountShouldBe = BigDecimal.valueOf(1.60);

        testMoneyStore.addToStore(amountToIncrease50Pence);
        testMoneyStore.addToStore(amountToIncrease10Pence);
        testMoneyStore.addToStore(amountToIncrease1Pound);
        BigDecimal resultAfterIncrease = testMoneyStore.getCurrentAmount();

        Assert.assertEquals(amountShouldBe,resultAfterIncrease);
    }

    @Test
    public void should_DecreaseCurrentAmount_WhenCurrentIs2PoundAndItemIs1Pound10Pence(){
        BigDecimal amountToIncrease = BigDecimal.valueOf(2.0);
        BigDecimal amountToDecrease = BigDecimal.valueOf(1.1);
        BigDecimal shouldBe = BigDecimal.valueOf(0.9);

        testMoneyStore.addToStore(amountToIncrease);
        testMoneyStore.removeFromStore(amountToDecrease);
        BigDecimal resultAfterDecrease = testMoneyStore.getCurrentAmount();

        Assert.assertEquals(shouldBe,resultAfterDecrease);
    }

    @Test
    public void should_ReturnStringFormattedWithPoundSignAndDecimals_WhenGivenAValue(){
        testMoneyStore.addToStore(BigDecimal.valueOf(3.52));

        String resultOfFormatting = testMoneyStore.getCurrentAmountFormattedAsString();
        String shouldBe = "£3.52";

        Assert.assertEquals(resultOfFormatting,shouldBe);
    }

    @After
    public void tearDown(){
        testMoneyStore = null;
    }

}