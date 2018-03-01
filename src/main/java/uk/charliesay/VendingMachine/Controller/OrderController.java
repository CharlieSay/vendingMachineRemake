package uk.charliesay.VendingMachine.Controller;

import uk.charliesay.VendingMachine.Button.CharacterButton;
import uk.charliesay.VendingMachine.Button.ItemButton;
import uk.charliesay.VendingMachine.Button.NumberButton;
import uk.charliesay.VendingMachine.Inventory.Item;
import uk.charliesay.VendingMachine.Money.PaymentTypes.BitcoinPayment;
import uk.charliesay.VendingMachine.Money.PaymentTypes.CardPayment;
import uk.charliesay.VendingMachine.Money.PaymentTypes.CashPayment;
import uk.charliesay.VendingMachine.Money.PaymentTypes.PaymentTypes;

import java.math.BigDecimal;

public class OrderController {

    private VendingMachine vendingMachine;

    public OrderController(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    public boolean OrderRequest(CharacterButton characterButton, NumberButton numberButton){
        ItemButton itemButton = whichButtonPressed(characterButton,numberButton);
        if (itemButton == null){
            vendingMachine.getDisplay().outputContent("Item does not exist for some reason");
            return false;
        }else{
            BigDecimal itemPrice = itemButton.getItem().getAbsolutePrice();
            PaymentTypes paymentTypes = paymentTypeNeeded();
            switch (paymentTypes) {
                case CASH:
                    CashPayment cashPayment = new CashPayment(itemPrice, vendingMachine.getMoneyStore());
                    if (cashPayment.makePayment()){
                        DispenseRequest(itemButton.getItem());
                        vendingMachine.getDisplay().readInput("Dispensed");
                        DecreaseItemQuantity();
                        return true;
                    }else{
                        vendingMachine.getDisplay().readInput("Not enough Funds");
                        return false;
                    }
//                case CARD_CONTACTLESS:
//                    new CardPayment(CardPayment.cardPaymentType.CONTACTLESS, itemPrice).makePayment();
//                    break;
//                case CARD_CHIP_PIN:
//                    new CardPayment(CardPayment.cardPaymentType.CHIP_PIN, itemPrice).makePayment();
//                    break;
//                case BITCOIN:
//                    new BitcoinPayment(itemPrice).makePayment();
//                    break;
            }
            return false;
        }
    }

    private ItemButton whichButtonPressed(CharacterButton characterButton, NumberButton numberButton){
        ItemButton itemRequested = vendingMachine.getItemMap().getItemButton(characterButton,numberButton);
        return itemRequested;
    }

    private PaymentTypes paymentTypeNeeded(){
        return PaymentTypes.CASH;
    }

    public void DispenseRequest(Item item){

    }

    public void DecreaseItemQuantity(){

    }

}
