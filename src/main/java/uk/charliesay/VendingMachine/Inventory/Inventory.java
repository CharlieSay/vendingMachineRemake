package uk.charliesay.VendingMachine.Inventory;

import uk.charliesay.VendingMachine.Button.ItemButton;

public interface Inventory {
     /*
        Checking the status of a Button / Item and what its quantity is.
      */

    boolean isSoldOut(ItemButton button);
}
