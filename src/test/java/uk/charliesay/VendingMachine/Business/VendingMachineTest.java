package uk.charliesay.VendingMachine.Business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.charliesay.VendingMachine.Controller.VendingMachine;
import uk.charliesay.VendingMachine.Display.ConsoleDisplay;
import uk.charliesay.VendingMachine.Display.Display;
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
        Display display = vendingMachine.getDisplay();
        MoneyStore moneyStore = vendingMachine.getMoneyStore();
        Dispenser dispenser = vendingMachine.getDispenser();
        ItemMap itemMap = vendingMachine.getItemMap();

        Assert.assertNotNull(display);
        Assert.assertNotNull(moneyStore);
        Assert.assertNotNull(dispenser);
        Assert.assertNotNull(itemMap);
    }

    @Test
    public void vendingMachine_ShouldSetUpCustomVariables_WhenGivenLoadedConstructor(){
        vendingMachine = new VendingMachine(new ConsoleDisplay(),new ItemMap());

        Display display = vendingMachine.getDisplay();
        MoneyStore moneyStore = vendingMachine.getMoneyStore();
        Dispenser dispenser = vendingMachine.getDispenser();
        ItemMap itemMap = vendingMachine.getItemMap();

        Assert.assertNotNull(display);
        Assert.assertNotNull(moneyStore);
        Assert.assertNotNull(dispenser);
        Assert.assertNotNull(itemMap);
    }
}