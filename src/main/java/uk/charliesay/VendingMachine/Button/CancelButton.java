package uk.charliesay.VendingMachine.Button;

import uk.charliesay.VendingMachine.Money.MoneyStore;

public class CancelButton extends Button {

    private void RefundCash(MoneyStore moneyStore){
        if (moneyStore.getCurrentAmount().intValueExact()>0){
            moneyStore.removeFromStore(moneyStore.getCurrentAmount());
        }
    }

    public void DeleteSelection(MoneyStore moneyStore){
        RefundCash(moneyStore);
    }
}
