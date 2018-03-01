package uk.charliesay.VendingMachine.Controller;

import uk.charliesay.VendingMachine.Business.Dispenser;
import uk.charliesay.VendingMachine.Display.ConsoleDisplay;
import uk.charliesay.VendingMachine.Display.Display;
import uk.charliesay.VendingMachine.Display.LcdDisplay;
import uk.charliesay.VendingMachine.Inventory.ItemMap;
import uk.charliesay.VendingMachine.Money.MoneyStore;

public class VendingMachine {

    private Display display;
    private MoneyStore moneyStore;
    private Dispenser dispenser;
    private ItemMap itemMap;

    //Customisable DISPLAY and ITEMS settings
    public VendingMachine(Display display, ItemMap itemMap) {
        this.display = display;
        this.moneyStore = new MoneyStore();
        this.dispenser = new Dispenser();
        this.itemMap = itemMap;
    }

    //Default Factory Settings
    public VendingMachine(){
        this.display = new LcdDisplay();
        this.moneyStore = new MoneyStore();
        this.dispenser = new Dispenser();
        this.itemMap = new ItemMap();
    }

    public Display getDisplay() {
        return display;
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
