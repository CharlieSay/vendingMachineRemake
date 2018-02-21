package uk.charliesay.VendingMachine.Business;

import uk.charliesay.VendingMachine.Exceptions.PhysicalException;
import uk.charliesay.VendingMachine.Inventory.Item;

public class Dispenser {

    public boolean dispenseItem(Item item) throws PhysicalException {
        if (item != null) {
            return true;
        }
        throw new PhysicalException("Item does not exist.");
    }

}
