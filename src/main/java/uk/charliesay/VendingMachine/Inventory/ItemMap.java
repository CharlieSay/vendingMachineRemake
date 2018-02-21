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
    public boolean isSoldOut(ItemButton buttonPressed) {
        return false;
    }

    public void addItemToList(ItemButton itemButton, Integer quantity){
        itemMap.put(itemButton,quantity);
    }

    public Item getItem(ItemButton itemButton) {
        if (itemButton.getItem() == null){
            return null;
        }else{
            for (Map.Entry<ItemButton, Integer> entry : itemMap.entrySet()) {
                ItemButton itemButtonIteration = entry.getKey();
                if (itemButtonIteration.getItem().getItemName().equals(itemButton.getItem().getItemName())) {
                    return itemButton.getItem();
                }
            }
        }
        return null;
    }

    public boolean decreaseQuantity(ItemButton itemButton){
        return false;
    }

}
