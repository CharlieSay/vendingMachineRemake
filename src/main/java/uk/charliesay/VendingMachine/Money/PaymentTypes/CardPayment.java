package uk.charliesay.VendingMachine.Money.PaymentTypes;

import uk.charliesay.VendingMachine.Money.Contactless;
import uk.charliesay.VendingMachine.Money.Payment;

public class CardPayment extends Payment implements Contactless{
    @Override
    public boolean makePayment() {
        System.out.println("\nWoah Card payment cool\n");
        return true;
    }

    @Override
    public void contactlessProtocool() {
        System.out.println("\nI am listening for contactless, boom its done.\n");
        makePayment();
    }
}
