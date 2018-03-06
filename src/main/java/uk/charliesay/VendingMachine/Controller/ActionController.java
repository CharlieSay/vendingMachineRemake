package uk.charliesay.VendingMachine.Controller;

import uk.charliesay.VendingMachine.Button.Button;
import uk.charliesay.VendingMachine.Button.CancelButton;
import uk.charliesay.VendingMachine.Button.CharacterButton;
import uk.charliesay.VendingMachine.Button.NumberButton;

import java.math.BigDecimal;

public class ActionController {

    CharacterButton characterButton;
    NumberButton numberButton;
    VendingMachine vendingMachine;

    public ActionController(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public boolean ButtonPress(Button button){
        if (button instanceof CharacterButton) characterButton = (CharacterButton) button;
        if (button instanceof NumberButton) numberButton = (NumberButton) button;
        if (button instanceof CancelButton){ ((CancelButton) button).DeleteSelection(vendingMachine.getMoneyStore()); orderClean();}
        if (haveBothButtonsBeenPressed()){
            OrderController orderController = new OrderController(vendingMachine);
            orderController.OrderRequest(characterButton,numberButton,"cash");
            return true;
        }
        return false;
    }

    private boolean haveBothButtonsBeenPressed(){
        return (characterButton != null && numberButton != null);
    }

    private void orderClean(){
        characterButton = null;
        numberButton = null;
    }

    public void MoneyInsert(BigDecimal amountInserted){
        vendingMachine.getMoneyStore().addToStore(amountInserted);
    }
}
