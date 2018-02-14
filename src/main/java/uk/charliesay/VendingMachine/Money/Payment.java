package uk.charliesay.VendingMachine.Money;

import java.math.BigDecimal;

public abstract class Payment implements MakePayment{
    /**
     * Make a Payment
     *
     * @return makePayment
     */
    public abstract boolean makePayment();
}
