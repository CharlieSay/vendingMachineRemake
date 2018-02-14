package uk.charliesay.VendingMachine.Money;

public interface Contactless {
    void contactlessProtocool();
}

/*
This has been implemented, because if I were to expand on CARD Payment types such as Visa, Amex etc.
they would most likely have different protocols of contactless, well that is my assumption,
therefore would need different "CardPayment" types
 */