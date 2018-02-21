package uk.charliesay.VendingMachine.Money;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MoneyStore {

    private BigDecimal currentAmount;

    public MoneyStore(){
        currentAmount = BigDecimal.valueOf(0.00).setScale(2, RoundingMode.CEILING);
    }

    public void addToStore(BigDecimal amountToAdd){
        currentAmount = currentAmount.add(amountToAdd);
    }

    public void removeFromStore(BigDecimal amountToRemove){
        currentAmount = currentAmount.subtract(amountToRemove);
    }

    public BigDecimal getCurrentAmount(){
        return currentAmount;
    }

    public String getCurrentAmountFormattedAsString(){
        return ("£"+new DecimalFormat("0.00").format(currentAmount));
    }
}
