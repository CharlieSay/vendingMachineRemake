package uk.charliesay.VendingMachine.Inventory;

import uk.charliesay.VendingMachine.Button.ItemButton;

import java.util.HashMap;
import java.util.Map;

public class ItemMap implements Inventory {

    private HashMap<ItemButton, Integer> itemInventoryMap;

    public ItemMap() {
        this.itemInventoryMap = new HashMap<>();
    }

    @Override
    public boolean isSoldOut(ItemButton buttonPressed) {
        return (getQuantity(buttonPressed) <= 0);
    }

    public void addItemToList(ItemButton itemButton, Integer quantity){
        itemInventoryMap.put(itemButton,quantity);
    }

    public void removeItemFromList(ItemButton itemButtonToRemove){
        for (Map.Entry<ItemButton, Integer> entry : itemInventoryMap.entrySet()) {
            ItemButton itemButtonIteration = entry.getKey();
            if (itemButtonIteration.getItem().getItemName().equals(itemButtonToRemove.getItem().getItemName())) {
                itemInventoryMap.remove(itemButtonIteration);
                break;
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder currentList = new StringBuilder();
        ItemButton itemButtonIteration;
        Integer itemButtonQuantity;
        for (Map.Entry<ItemButton, Integer> entry : itemInventoryMap.entrySet()) {
            itemButtonIteration = entry.getKey();
            itemButtonQuantity = entry.getValue();
            currentList.append(itemButtonIteration.getItem().getFriendlyDetails());
            currentList.append(" Button : " + itemButtonIteration.getFriendlyName());
            currentList.append(" Quantity : " + itemButtonQuantity + "\n");
        }
        return currentList.toString();
    }

    public Item getItem(ItemButton itemButton) {
        for (Map.Entry<ItemButton, Integer> entry : itemInventoryMap.entrySet()) {
            ItemButton itemButtonIteration = entry.getKey();
            if (itemButtonIteration.getItem().getItemName().equals(itemButton.getItem().getItemName())) {
                return itemButton.getItem();
            }
            }
        return null;
    }

    //////////////////
    //QUANTITY BLOCK//
    //////////////////

    public boolean setQuantity(ItemButton itemButton, Integer setTo){
        for (Map.Entry<ItemButton, Integer> entry : itemInventoryMap.entrySet()) {
            if (itemButton.getFriendlyName().equals(entry.getKey().getFriendlyName())) {
                entry.setValue(setTo);
                return true;
            }
        }
        return false;
    }

    public Integer getQuantity(ItemButton itemButton) {
        for (Map.Entry<ItemButton, Integer> entry : itemInventoryMap.entrySet()) {
        if (itemButton.getFriendlyName().equals(entry.getKey().getFriendlyName())) {
            return entry.getValue();
            }
        }
        return null;
    }

    public boolean decreaseQuantity(ItemButton itemButton){
        for (Map.Entry<ItemButton, Integer> entry : itemInventoryMap.entrySet()) {
            if (itemButton.getFriendlyName().equals(entry.getKey().getFriendlyName())){
                Integer currentAmount = entry.getValue();
                entry.setValue(--currentAmount);
                return true;
            }
        }
        return false;
    }

}
