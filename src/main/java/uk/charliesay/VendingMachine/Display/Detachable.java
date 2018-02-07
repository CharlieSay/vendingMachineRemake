package uk.charliesay.VendingMachine.Display;

public interface Detachable {
    DetachableStates detach();
}


enum DetachableStates{
    DETACHED,
    ERROR_INDEATCH,
    UNKNOWN_ERROR;
}
