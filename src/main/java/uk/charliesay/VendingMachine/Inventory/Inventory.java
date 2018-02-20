package uk.charliesay.VendingMachine.Inventory;

import uk.charliesay.VendingMachine.Button.Button;

public interface Inventory {
     /*
        Checking the status of a Button / Item and what its quantity is.
      */

    boolean isSoldOut(Button button);
}
