package uk.charliesay.VendingMachine.Inventory;

import uk.charliesay.VendingMachine.Button.Button;

import java.util.HashMap;

public class ItemMap implements Inventory{

    private HashMap<Button,Integer> itemMap;

    public ItemMap() {
        this.itemMap = new HashMap<>();
    }

    @Override
    public boolean isSoldOut(Button buttonPressed) {
        itemMap.put(new Button(),1);
        return false;
    }
}
