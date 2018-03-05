package uk.charliesay.VendingMachine.Controller;

import uk.charliesay.VendingMachine.Button.CharacterButton;
import uk.charliesay.VendingMachine.Button.ItemButton;
import uk.charliesay.VendingMachine.Button.NumberButton;
import uk.charliesay.VendingMachine.Exceptions.PhysicalException;
import uk.charliesay.VendingMachine.Inventory.Item;
import uk.charliesay.VendingMachine.Money.PaymentTypes.BitcoinPayment;
import uk.charliesay.VendingMachine.Money.PaymentTypes.CardPayment;
import uk.charliesay.VendingMachine.Money.PaymentTypes.CashPayment;
import uk.charliesay.VendingMachine.Money.PaymentTypes.PaymentTypes;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderController {

    private static final String DISPENSED = "Dispensed";
    private VendingMachine vendingMachine;

    public OrderController(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    public boolean OrderRequest(CharacterButton characterButton, NumberButton numberButton, String paymentNeeded){
        ItemButton itemButton = whichButtonPressed(characterButton,numberButton);
        if (itemButton == null || itemButton.getItem() == null){
            vendingMachine.getDisplay().outputContent("Please try another selection");
            String error = "Selecton made to missing product : " + numberButton.getButtonID()+"\n"+"With Payment Type "+paymentNeeded;
            Logger.getGlobal().log(Level.WARNING, "Something went wrong: {0} ", error);
            return false;
        }else{
            PaymentTypes paymentTypes = paymentTypeNeeded(paymentNeeded);
            if (paymentTypes == null){
                String error = "Correct CHAR and NUMBER Button however Payment type incorrect " +paymentNeeded;
                Logger.getGlobal().log(Level.SEVERE, "Something went wrong: {0} ", error);
                return false;
            }
            BigDecimal itemPrice = itemButton.getItem().getAbsolutePrice();
            switch (paymentTypes) {
                case CASH:
                    CashPayment cashPayment = new CashPayment(itemPrice, vendingMachine.getMoneyStore());
                    if (cashPayment.makePayment()){
                        DispenseRequest(itemButton.getItem());
                        vendingMachine.getDisplay().outputContent(DISPENSED);
                        DecreaseItemQuantity(itemButton);
                        return true;
                    }else{
                        vendingMachine.getDisplay().outputContent("Not enough Funds");
                        return false;
            }
                case CARD_CONTACTLESS:
                    new CardPayment(CardPayment.cardPaymentType.CONTACTLESS, itemPrice).makePayment();
                    vendingMachine.getDisplay().outputContent(DISPENSED);
                    return true;
                case CARD_CHIP_PIN:
                    new CardPayment(CardPayment.cardPaymentType.CHIP_PIN, itemPrice).makePayment();
                    vendingMachine.getDisplay().outputContent(DISPENSED);
                    return true;
                case BITCOIN:
                    new BitcoinPayment(itemPrice).makePayment();
                    vendingMachine.getDisplay().outputContent(DISPENSED);
                    return true;
            }
        }
        return false;
    }

    private ItemButton whichButtonPressed(CharacterButton characterButton, NumberButton numberButton){
        return vendingMachine.getItemMap().getItemButton(characterButton,numberButton);
    }

    //This is literally just for SHOWCASE Purposes, this'll obviously work if in a LIVE environment select the right form.
    private PaymentTypes paymentTypeNeeded(String neededAsString){
        if (neededAsString.equalsIgnoreCase("cash")) return PaymentTypes.CASH;
        else if (neededAsString.equalsIgnoreCase("contactless")) return PaymentTypes.CARD_CONTACTLESS;
        else if (neededAsString.equalsIgnoreCase("chip")) return PaymentTypes.CARD_CHIP_PIN;
        else if (neededAsString.equalsIgnoreCase("btc")) return PaymentTypes.BITCOIN;
        else return null;
    }

    private void DispenseRequest(Item item){
        try {
            vendingMachine.getDispenser().dispenseItem(item);
        } catch (PhysicalException e) {
            Logger.getGlobal().log(Level.SEVERE,e.getMessage());
        }
    }

    private void DecreaseItemQuantity(ItemButton itemButton){
        vendingMachine.getItemMap().decreaseQuantity(itemButton);
    }

}
