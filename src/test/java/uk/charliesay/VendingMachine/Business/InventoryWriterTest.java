package uk.charliesay.VendingMachine.Business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class InventoryWriterTest {

    InventoryWriter inventoryWriter;

    @Before
    public void setUp(){
        inventoryWriter = new InventoryWriter();
    }

    @Test
    public void test_ForNotNull(){
        Assert.assertNotNull(inventoryWriter);
    }

}