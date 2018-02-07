package uk.charliesay.VendingMachine.Business;

import uk.charliesay.VendingMachine.Display.ConsoleDisplay;
import uk.charliesay.VendingMachine.Display.DisplayType;
import uk.charliesay.VendingMachine.Inventory.ItemMap;
import uk.charliesay.VendingMachine.Money.MoneyStore;

public class VendingMachine {

    private DisplayType displayType;
    private MoneyStore moneyStore;
    private Dispenser dispenser;
    private ItemMap itemMap;


    //Customisable DISPLAY and ITEMS settings
    public VendingMachine(DisplayType displayType, ItemMap itemMap) {
        this.displayType = displayType;
        this.moneyStore = new MoneyStore();
        this.dispenser = new Dispenser();
        this.itemMap = itemMap;
    }

    //Default Factory Settings
    public VendingMachine(){
        this.displayType = new ConsoleDisplay();
        this.moneyStore = new MoneyStore();
        this.dispenser = new Dispenser();
        this.itemMap = new ItemMap();
    }

    public DisplayType getDisplayType() {
        return displayType;
    }

    public MoneyStore getMoneyStore() {
        return moneyStore;
    }

    public Dispenser getDispenser() {
        return dispenser;
    }

    public ItemMap getItemMap() {
        return itemMap;
    }
}
