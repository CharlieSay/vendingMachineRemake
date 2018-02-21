package uk.charliesay.VendingMachine.Business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryReaderTest {

    InventoryReader inventoryReader;

    @Before
    public void setUp(){
        inventoryReader = new InventoryReader();
    }

    @Test
    public void test_ForNotNull(){
        Assert.assertNotNull(inventoryReader);
    }

}