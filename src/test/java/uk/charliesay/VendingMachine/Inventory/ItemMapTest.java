package uk.charliesay.VendingMachine.Inventory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.charliesay.VendingMachine.Button.CharacterButton;
import uk.charliesay.VendingMachine.Button.ItemButton;
import uk.charliesay.VendingMachine.Button.NumberButton;

import java.math.BigDecimal;

import static uk.charliesay.VendingMachine.Button.CharacterButton.availableCharacters.*;

public class ItemMapTest {

    ItemMap itemMapTestObject;

    @Before
    public void setUp(){
        itemMapTestObject = new ItemMap();
    }

    @Test
    public void should_BeFalseSoldOut(){
        Assert.assertFalse(itemMapTestObject.isSoldOut(null));
    }

    @Test
    public void should_AddItemToMap_ThenRetrieveWithRightData(){
        Item sprite = new Item(new BigDecimal(1.00),"Sprite");
        CharacterButton characterButton = new CharacterButton(B);
        NumberButton numberButton = new NumberButton(1);
        ItemButton buttonIn = new ItemButton(characterButton,numberButton,sprite);

        itemMapTestObject.addItemToList(buttonIn,10);
        Item result = itemMapTestObject.getItem();

        Assert.assertEquals(sprite.getItemName(),result.getItemName());
        Assert.assertEquals(sprite.getAbsolutePrice(),result.getAbsolutePrice());
        Assert.assertEquals(sprite.getFriendlyDetails(),result.getFriendlyDetails());
    }
}