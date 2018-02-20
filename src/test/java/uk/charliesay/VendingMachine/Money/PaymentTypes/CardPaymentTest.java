package uk.charliesay.VendingMachine.Money.PaymentTypes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CardPaymentTest {

    CardPayment testCardPayment;
    String shouldBeCardNumber = "4716415419526949"; //Will be same for all tests.

    @Test
    public void should_NotBeNull(){
        testCardPayment = new CardPayment(CardPayment.cardPaymentType.CONTACTLESS,new BigDecimal(1.00));

        Assert.assertNotNull(testCardPayment);
    }

    @Test
    public void should_HitContactlessMethod_SettingDetailsAboutPayment(){
        testCardPayment = new CardPayment(CardPayment.cardPaymentType.CONTACTLESS,new BigDecimal(1.00));

        Integer shouldBeCardPin = 1234;
        BigDecimal shouldBePaymentAmount = new BigDecimal(1.00);

        String resultCardNumber = testCardPayment.getCardNumber();
        Integer resultCardPin = testCardPayment.getCardPin();
        BigDecimal resultPaymentAmount = testCardPayment.getPaymentAmount();

        Assert.assertEquals(shouldBeCardNumber,resultCardNumber);
        Assert.assertEquals(shouldBeCardPin,resultCardPin);
        Assert.assertEquals(shouldBePaymentAmount,resultPaymentAmount);
        Assert.assertTrue(testCardPayment.makePayment());
    }

    @Test
    public void should_HitChipAndPinMethod_SettingDetailsAboutPayment(){
        testCardPayment = new CardPayment(CardPayment.cardPaymentType.CHIP_PIN,new BigDecimal(1.00));

        Integer shouldBeCardPin = 4321;
        BigDecimal shouldBePaymentAmount = new BigDecimal(1.00);

        String resultCardNumber = testCardPayment.getCardNumber();
        Integer resultCardPin = testCardPayment.getCardPin();
        BigDecimal resultPaymentAmount = testCardPayment.getPaymentAmount();

        Assert.assertEquals(shouldBeCardNumber,resultCardNumber);
        Assert.assertEquals(shouldBeCardPin,resultCardPin);
        Assert.assertEquals(shouldBePaymentAmount,resultPaymentAmount);
        Assert.assertTrue(testCardPayment.makePayment());
    }

    @Test
    public void makePayment_ShouldReturnFalse_IfAnyThingDetailsAreNull(){
        testCardPayment = new CardPayment(null,null);

        Assert.assertFalse(testCardPayment.makePayment());
    }


    @After
    public void tearDown(){
        testCardPayment = null;
    }

}