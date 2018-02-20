package uk.charliesay.VendingMachine.Inventory;

import uk.charliesay.VendingMachine.Button.Button;
import uk.charliesay.VendingMachine.Button.ItemButton;

import java.util.HashMap;
import java.util.Map;

public class ItemMap implements Inventory {

    private HashMap<ItemButton, Integer> itemMap;

    public ItemMap() {
        this.itemMap = new HashMap<>();
    }

    @Override
    public boolean isSoldOut(Button buttonPressed) {
        return false;
    }

    public void addItemToList(ItemButton itemButton, Integer quantity){
        itemMap.put(itemButton,quantity);
    }

    public Item getItem() {
        for (Map.Entry<ItemButton, Integer> entry : itemMap.entrySet()) {
            ItemButton key = entry.getKey();
            Integer value = entry.getValue();
            return key.getItem();
        }
        return null;
    }
}
