package uk.charliesay.VendingMachine.Money.PaymentTypes;

import uk.charliesay.VendingMachine.Money.MoneyStore;
import uk.charliesay.VendingMachine.Money.Payment;

import java.math.BigDecimal;

public class CashPayment extends Payment {

    private MoneyStore moneyStore;
    private BigDecimal amountToPay;
    private BigDecimal amountBeforeTransaction;

    public CashPayment(BigDecimal amountToPay, MoneyStore moneyStore){
            this.moneyStore = moneyStore;
            this.amountToPay = amountToPay;
            this.amountBeforeTransaction = moneyStore.getCurrentAmount();
    }

    public boolean makePayment() {
        if (fundCheck()){
            moneyStore.removeFromStore(amountToPay);
            return true;
        }
        return false;
    }

    private boolean fundCheck(){
        return (amountBeforeTransaction.compareTo(amountToPay) >= 0);
    }
}
