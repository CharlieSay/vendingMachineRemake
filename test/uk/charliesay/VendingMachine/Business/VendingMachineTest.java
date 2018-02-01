package uk.charliesay.VendingMachine.Business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.charliesay.VendingMachine.Display.ConsoleDisplay;
import uk.charliesay.VendingMachine.Display.DisplayType;
import uk.charliesay.VendingMachine.Inventory.ItemMap;
import uk.charliesay.VendingMachine.Money.MoneyStore;

public class VendingMachineTest {

    private VendingMachine vendingMachine;

    @Before
    public void setUp(){
        vendingMachine = new VendingMachine();
    }

    @Test
    public void vendingMachine_ShouldSetUpVariables_WhenGivenEmptyConstructor(){
        DisplayType displayType = vendingMachine.getDisplayType();
        MoneyStore moneyStore = vendingMachine.getMoneyStore();
        Dispenser dispenser = vendingMachine.getDispenser();
        ItemMap itemMap = vendingMachine.getItemMap();

        Assert.assertNotNull(displayType);
        Assert.assertNotNull(moneyStore);
        Assert.assertNotNull(dispenser);
        Assert.assertNotNull(itemMap);
    }

    @Test
    public void vendingMachine_ShouldSetUpCustomVariables_WhenGivenLoadedConstructor(){
        vendingMachine = new VendingMachine(new ConsoleDisplay(),new ItemMap());

        DisplayType displayType = vendingMachine.getDisplayType();
        MoneyStore moneyStore = vendingMachine.getMoneyStore();
        Dispenser dispenser = vendingMachine.getDispenser();
        ItemMap itemMap = vendingMachine.getItemMap();

        Assert.assertNotNull(displayType);
        Assert.assertNotNull(moneyStore);
        Assert.assertNotNull(dispenser);
        Assert.assertNotNull(itemMap);
    }

}