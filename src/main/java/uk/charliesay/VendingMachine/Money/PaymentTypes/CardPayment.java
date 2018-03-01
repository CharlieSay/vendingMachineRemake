package uk.charliesay.VendingMachine.Money.PaymentTypes;

import uk.charliesay.VendingMachine.Money.Contactless;
import uk.charliesay.VendingMachine.Money.Payment;

import java.math.BigDecimal;

/*
To IMPLEMENT
CARD NUMBER
CARD PIN
CONTACTLESS PROTOCOOL
Just to make it look nicer.
4716415419526949 - VISA
 */

public class CardPayment extends Payment implements Contactless{

    public enum cardPaymentType{
        CHIP_PIN,
        CONTACTLESS;
    }

    private String cardNumber;
    private Integer cardPin;
    private BigDecimal paymentAmount;

    @Override
    public boolean makePayment() {
        if (cardPin != null || cardNumber != null || paymentAmount != null){
            return true;
        }
        return false;
    }

    public CardPayment(cardPaymentType cp, BigDecimal amountToPay){
        if (cp == cardPaymentType.CHIP_PIN){
            chipPinProtocool();
            this.paymentAmount = amountToPay;
            makePayment();
        }else if (cp == cardPaymentType.CONTACTLESS){
            contactlessProtocool();
            this.paymentAmount = amountToPay;
            makePayment();
        }else{
            System.out.println("Something went wrong...\nCouldn't catch type of card payment.");
            cardNumber = null;
            cardPin = null;
            paymentAmount = null;
        }
    }

    @Override
    public void contactlessProtocool() {
        cardNumber = "4716415419526949";
        cardPin = 1234;
    }

    public void chipPinProtocool(){
        cardNumber = "4716415419526949";
        cardPin = 4321;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getCardPin() {
        return cardPin;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }
}
