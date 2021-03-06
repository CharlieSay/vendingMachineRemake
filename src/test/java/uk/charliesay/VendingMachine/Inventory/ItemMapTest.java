package uk.charliesay.VendingMachine.Inventory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.charliesay.VendingMachine.Button.CharacterButton;
import uk.charliesay.VendingMachine.Button.ItemButton;
import uk.charliesay.VendingMachine.Button.NumberButton;

import java.math.BigDecimal;

import static uk.charliesay.VendingMachine.Button.CharacterButton.availableCharacters.*;

public class ItemMapTest {

    private ItemMap itemMapTestObject;
    private Item testSpriteItem;
    private CharacterButton testSpriteCharacterButton;
    private NumberButton testSpriteNumberButton;
    private ItemButton testSpriteItemButton;

    @Before
    public void setUp() {
        itemMapTestObject = new ItemMap();
        testSpriteItem = new Item(new BigDecimal(1.00), "Sprite");
        testSpriteCharacterButton = new CharacterButton(A);
        testSpriteNumberButton = new NumberButton(1);
        testSpriteItemButton = new ItemButton(testSpriteCharacterButton, testSpriteNumberButton, testSpriteItem);
        itemMapTestObject.addItemToList(testSpriteItemButton, 10);
    }

    @Test
    public void shouldNot_BeSoldOut() {
        itemMapTestObject.setQuantity(testSpriteItemButton,0);
        Assert.assertTrue(itemMapTestObject.isSoldOut(testSpriteItemButton));
    }

    @Test
    public void should_BeSoldOut(){
        Assert.assertFalse(itemMapTestObject.isSoldOut(testSpriteItemButton));
    }

    @Test
    public void should_AddItemToMap_ThenRetrieveItBackAndAllDataAssert() {
        itemMapTestObject.addItemToList(testSpriteItemButton, 10);
        Item result = itemMapTestObject.getItem(testSpriteItemButton);

        Assert.assertEquals(testSpriteItem.getItemName(), result.getItemName());
        Assert.assertEquals(testSpriteItem.getAbsolutePrice(), result.getAbsolutePrice());
        Assert.assertEquals(testSpriteItem.getFriendlyDetails(), result.getFriendlyDetails());
    }

    @Test
    public void should_AddItemToMap_ThenReturnNullWhenRequestingItemThatIsntInMap() {
        Item drPepper = new Item(new BigDecimal(1.00), "Dr Pepper");
        CharacterButton drPepperCharacterButton = new CharacterButton(B);
        NumberButton drPepperNumberButton = new NumberButton(1);
        ItemButton drPepperItemButton = new ItemButton(drPepperCharacterButton, drPepperNumberButton, drPepper);

        itemMapTestObject.addItemToList(testSpriteItemButton, 10);

        Assert.assertNull(itemMapTestObject.getItem(drPepperItemButton));
    }

    @Test
    public void shouldNot_DecreaseQuantityOfAnyIntegerInMap_WhenAskedToRemoveAnItemThatDoesntExist() {
        ItemButton dummyItemButton = dummyButton();
        Assert.assertFalse(itemMapTestObject.decreaseQuantity(dummyItemButton));
    }

    @Test
    public void should_DecreaseQuantityOfIntegerInMap_WhenAskedToRemoveAnItemThatDoesExist() {
        itemMapTestObject.decreaseQuantity(testSpriteItemButton);
        Integer result = itemMapTestObject.getQuantity(testSpriteItemButton);
        Assert.assertEquals(new Integer(9).intValue(),result.intValue());
    }

    @Test
    public void should_ReturnQuantityNull_IfItemDoesNotExist(){
        ItemButton dummyItemButton = dummyButton();
        Assert.assertNull(itemMapTestObject.getQuantity(dummyItemButton));
    }

    @Test
    public void should_SetQuantityOfIntegerInMap_WhenGivenValidItem_ThenReturnTrue(){
        Integer testCaseInteger15 = 15;
        itemMapTestObject.setQuantity(testSpriteItemButton,testCaseInteger15);
        Integer resultAfterIncrease = itemMapTestObject.getQuantity(testSpriteItemButton);
        Assert.assertEquals(testCaseInteger15,resultAfterIncrease);
    }

    @Test
    public void should_SetQuantityOfIntegerInMap_WhenGivenInvalidItem_ThenReturnFalse(){
        ItemButton dummyItemButton = dummyButton();
        boolean resultAfterIncrease = itemMapTestObject.setQuantity(dummyItemButton,5);
        Assert.assertFalse(resultAfterIncrease);
    }

    @Test
    public void should_giveStringOfCurrentInventory_WhenRequested(){
        String resultShouldBe =
                "Item Name : Sprite Item Price : 1.00 Button : A1 Quantity : 10\n";
        Assert.assertEquals(resultShouldBe,itemMapTestObject.toString());
    }

    @Test
    public void should_RemoveItemFromList_WhenGivenAValidItemThatMatchesAListedItem(){
        Item drPepper = new Item(new BigDecimal(1.00), "Dr Pepper");
        CharacterButton drPepperCharacterButton = new CharacterButton(B);
        NumberButton drPepperNumberButton = new NumberButton(1);
        ItemButton drPepperItemButton = new ItemButton(drPepperCharacterButton, drPepperNumberButton, drPepper);
        String resultShouldBe = "Item Name : Sprite Item Price : 1.00 Button : A1 Quantity : 10\n";

        itemMapTestObject.addItemToList(drPepperItemButton, 10);
        itemMapTestObject.removeItemFromList(drPepperItemButton);

        Assert.assertEquals(resultShouldBe,itemMapTestObject.toString());
    }

    private ItemButton dummyButton(){
        Item dummyItem = new Item(new BigDecimal(1.00), "Dummy");
        CharacterButton dummyCharacterButton = new CharacterButton(C);
        NumberButton dummyNumberButton = new NumberButton(1);
        ItemButton dummyItemButton = new ItemButton(dummyCharacterButton, dummyNumberButton, dummyItem);
        return dummyItemButton;
    }

    @After
    public void tearDown() {
        testSpriteItem = null;
        testSpriteCharacterButton = null;
        testSpriteNumberButton = null;
        testSpriteItemButton = null;
        itemMapTestObject = null;
    }
}