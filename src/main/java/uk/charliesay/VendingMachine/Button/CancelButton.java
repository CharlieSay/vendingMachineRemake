package uk.charliesay.VendingMachine.Button;

import uk.charliesay.VendingMachine.Money.MoneyStore;

public class CancelButton extends Button {
    final Integer buttonID = 10;

    public void refundCash(MoneyStore moneyStore){
        if (moneyStore.getCurrentAmount().intValueExact()>0){
            moneyStore.removeFromStore(moneyStore.getCurrentAmount());
        }
    }
}
