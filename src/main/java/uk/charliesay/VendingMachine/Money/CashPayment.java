package uk.charliesay.VendingMachine.Money;

import java.math.BigDecimal;

public class CashPayment extends Payment{

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
        int resultFromFundCheck = amountBeforeTransaction.compareTo(amountToPay);
        if (resultFromFundCheck == -1){
            return false;
        }
        paymentSuccessful();
        return true;
    }

    private boolean paymentSuccessful() {
        int resultFromTransaction = amountBeforeTransaction.subtract(amountToPay)
                                                           .compareTo(moneyStore.getCurrentAmount());
        switch (resultFromTransaction){
            case (-1):
                return false;
            case (0):
                return true;
            case (1):
                return false;
        }
        return false;
    }
}
