package uk.charliesay.VendingMachine.Display;

import uk.charliesay.VendingMachine.Exceptions.InDetachmentException;

public interface Detachable {
    boolean detachScreen(String inputDetachCode) throws InDetachmentException;
}
