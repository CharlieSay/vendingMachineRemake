package uk.charliesay.VendingMachine.Money.PaymentTypes;

import uk.charliesay.VendingMachine.Money.Contactless;
import uk.charliesay.VendingMachine.Money.Payment;

public class CardPayment extends Payment implements Contactless{
    @Override
    public boolean makePayment() {
        System.out.println("Woah Card payment cool");
        return true;
    }

    @Override
    public void contactlessProtocool() {
        System.out.println("I am listening for contactless, boom its done.");
        makePayment();
    }
}
