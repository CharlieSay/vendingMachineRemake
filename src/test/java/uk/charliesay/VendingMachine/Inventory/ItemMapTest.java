package uk.charliesay.VendingMachine.Inventory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.charliesay.VendingMachine.Button.Button;

public class ItemMapTest {

    ItemMap itemMapTestObject;

    @Before
    public void setUp(){
        itemMapTestObject = new ItemMap();
    }

    @Test
    public void test(){
        Assert.assertFalse(itemMapTestObject.isSoldOut(new Button()));
    }

}