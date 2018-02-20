package uk.charliesay.VendingMachine.Money.PaymentTypes;

import uk.charliesay.VendingMachine.Money.Contactless;
import uk.charliesay.VendingMachine.Money.Payment;

import java.util.Random;

/*
To IMPLEMENT
CARD NUMBER
CARD PIN
CONTACTLESS PROTOCOOL
Just to make it look nicer.
4716415419526949 - VISA
 */

public class CardPayment extends Payment implements Contactless{

    private String cardNumber;
    private String cardPin;

    @Override
    public boolean makePayment() {
        if (true){
            cardProcessing(cardPaymentType.CHIP_PIN);
            return true;
        }else{
            cardProcessing(cardPaymentType.CONTACTLESS);
            return true;
        }
    }

    private boolean cardProcessing(cardPaymentType cardPaymentType){
        if (cardPaymentType == CardPayment.cardPaymentType.CHIP_PIN){
            cardNumber = "4716415419526949";
            cardPin = "7123";
            return true;
        }else if(cardPaymentType == CardPayment.cardPaymentType.CONTACTLESS){
            contactlessProtocool();
            return true;
        }
        return false;
    }

    @Override
    public void contactlessProtocool() {
        cardNumber = "4716415419526949";
        cardPin = "7123";
    }

    enum cardPaymentType{
        CHIP_PIN,
        CONTACTLESS;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardPin() {
        return cardPin;
    }
}
