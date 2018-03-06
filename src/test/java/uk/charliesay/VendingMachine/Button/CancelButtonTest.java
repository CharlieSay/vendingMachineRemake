package uk.charliesay.VendingMachine.Button;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.charliesay.VendingMachine.Money.MoneyStore;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CancelButtonTest {

    private CancelButton cancelButtonTestObject;

    @Before
    public void setUp(){
        cancelButtonTestObject = new CancelButton();
    }

    @Test
    public void should_RemoveFundsFromStore_WhenRefundCashIsCalled(){
        MoneyStore moneyStore = new MoneyStore();
        moneyStore.addToStore(new BigDecimal(5.00).setScale(2, RoundingMode.CEILING));

        cancelButtonTestObject.DeleteSelection(moneyStore);

        BigDecimal moneyInStoreAfterRemoval = moneyStore.getCurrentAmount();

        Assert.assertEquals("0.00",moneyInStoreAfterRemoval.toPlainString());
    }

}