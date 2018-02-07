package uk.charliesay.VendingMachine.Exceptions;

public class ZeroQuantityException extends Exception {

    public ZeroQuantityException(String message){
        super(message);
    }
}
