package uk.charliesay.VendingMachine.Inventory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ItemTest {

    Item itemTestObject;

    @Test
    public void should_notBeNull_OnceInstantiated(){
        BigDecimal price = BigDecimal.valueOf(1.00);

        itemTestObject = new Item(price,"Fanta");

        Assert.assertNotNull(itemTestObject);
    }

    @Test
    public void should_GiveBackCorrectFriendlyDetails(){
        BigDecimal price = BigDecimal.valueOf(1.20);

        itemTestObject = new Item(price,"Dr Pepper");

        String resultFriendlyDetails = itemTestObject.getFriendlyDetails();
        String shouldBe = ("Item Name : Dr Pepper\nItem Price : 1.20");

        Assert.assertEquals(resultFriendlyDetails,shouldBe);
    }

    @Test
    public void should_ReturnIndividualAttributes(){
        BigDecimal price = BigDecimal.valueOf(1.20).setScale(2, RoundingMode.CEILING);
        String sprite = "Sprite";

        itemTestObject = new Item(price,sprite);

        String resultName = itemTestObject.getItemName();
        BigDecimal resultPrice = itemTestObject.getAbsolutePrice();

        Assert.assertEquals(sprite,resultName);
        Assert.assertEquals(price,resultPrice);
    }

    @After
    public void tearDown(){
        itemTestObject = null;
    }

}