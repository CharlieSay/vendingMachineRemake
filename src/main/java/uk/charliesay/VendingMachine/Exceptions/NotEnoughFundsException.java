package uk.charliesay.VendingMachine.Exceptions;

public class NotEnoughFundsException extends Exception {

    public NotEnoughFundsException(String message){
        super(message);
    }
}
