package uk.charliesay.VendingMachine.Money;

import java.math.BigDecimal;

public abstract class Payment implements MakePayment{
    public abstract boolean makePayment();
}
