package uk.charliesay.VendingMachine.Money.PaymentTypes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CardPaymentTest {

    CardPayment testCardPayment;


    @Before
    public void classSetUp(){
        testCardPayment = new CardPayment();
    }

    @Test
    public void should_ReturnTrue_WhenTryingPayment(){
        Assert.assertTrue(testCardPayment.makePayment());
    }


}