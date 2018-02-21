package uk.charliesay.VendingMachine.Business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.charliesay.VendingMachine.Exceptions.PhysicalException;
import uk.charliesay.VendingMachine.Inventory.Item;

import java.math.BigDecimal;

public class DispenserTest {

    Dispenser dispenserTestObject;

    @Before
    public void setUp(){
        dispenserTestObject = new Dispenser();
    }

    @Test
    public void should_DispenseItemThatIsValid_ReturningTrue() throws PhysicalException {
        Item item = new Item(new BigDecimal(0),"");

        boolean booleanResult = dispenserTestObject.dispenseItem(item);

        Assert.assertTrue(booleanResult);
    }

    @Test(expected = PhysicalException.class)
    public void should_NotDispenseItemBecauseINVALID_ThrowingException() throws PhysicalException {
        Item item = null;

        dispenserTestObject.dispenseItem(item);
    }

}