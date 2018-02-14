package uk.charliesay.VendingMachine.Money;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;

public class CashPaymentTest {

    private CashPayment testCashPayment;

    @Test
    public void should_ReturnFalse_WhenTransactionValueIsGreaterThanMoneyInStore(){
        BigDecimal onePoundBigDecimal = new BigDecimal(1.00);
        MoneyStore moneyStore = new MoneyStore();
        testCashPayment = new CashPayment(onePoundBigDecimal,moneyStore);

        int testValue = moneyStore.getCurrentAmount().compareTo(new BigDecimal(0.00));

        Assert.assertFalse(testCashPayment.makePayment());
        Assert.assertThat(testValue,is(0));
    }

    @Test
    public void should_ReturnTrue_WhenTransactionValueIsLessThanMoneyInStore(){
        BigDecimal onePoundBigDecimal = new BigDecimal(1.00);
        MoneyStore moneyStore = new MoneyStore();
        moneyStore.addToStore(new BigDecimal(5.00));
        testCashPayment = new CashPayment(onePoundBigDecimal,moneyStore);

        int testValue = moneyStore.getCurrentAmount().compareTo(new BigDecimal(4.00));

        Assert.assertTrue(testCashPayment.makePayment());
        Assert.assertThat(testValue,is(1));
    }

    @Test
    public void should_ReturnTrue_WhenTransactionValueIsEqualThanMoneyInStore(){
        BigDecimal onePoundBigDecimal = new BigDecimal(1.00);
        MoneyStore moneyStore = new MoneyStore();
        moneyStore.addToStore(new BigDecimal(1.00));
        testCashPayment = new CashPayment(onePoundBigDecimal,moneyStore);

        boolean resultBoolean = testCashPayment.makePayment();
        int testValue = moneyStore.getCurrentAmount().compareTo(new BigDecimal(0.00));

        Assert.assertTrue(resultBoolean);
        Assert.assertThat(testValue,is(0));
    }

    @After
    public void stripDown(){
        testCashPayment = null;
    }
}