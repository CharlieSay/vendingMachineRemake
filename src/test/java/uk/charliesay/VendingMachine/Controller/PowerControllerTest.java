package uk.charliesay.VendingMachine.Controller;

import org.junit.Assert;
import org.junit.Test;

public class PowerControllerTest {

    PowerController powerController;

    @Test
    public void should_CreateAndPopulateItemList_MockOfTurnOn(){
        powerController = new PowerController();
        Assert.assertNotNull(powerController.vendingMachine.getItemMap());
    }

    @Test
    public void should_NullVendingMachine_MockTurnOff(){
        powerController = new PowerController();
        powerController.turnOff();

        Assert.assertNull(powerController.vendingMachine);
    }

}