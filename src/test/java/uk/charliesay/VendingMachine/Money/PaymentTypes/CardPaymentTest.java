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

    @Test
    public void should_SetContactlessDetails(){
        testCardPayment.contactlessProtocool();

        String returnNumber = testCardPayment.getCardNumber();
        String returnPin = testCardPayment.getCardPin();

        String shouldBeNumber = "4716415419526949";
        String shouldBeCardPin = "7123";

        Assert.assertEquals(returnNumber,shouldBeNumber);
        Assert.assertEquals(returnPin,shouldBeCardPin);
    }

    @Test
    public void test(){
        Boolean wasPaymentSuccessful = testCardPayment.makePayment();
        String shouldBeNumber = "4716415419526949";
        String shouldBeCardPin = "7123";

        String returnNumber = testCardPayment.getCardNumber();
        String returnPin = testCardPayment.getCardPin();

        Assert.assertTrue(wasPaymentSuccessful);
        Assert.assertEquals(returnNumber,shouldBeNumber);
        Assert.assertEquals(returnPin,shouldBeCardPin);
    }

}