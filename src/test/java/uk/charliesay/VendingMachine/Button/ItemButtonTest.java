package uk.charliesay.VendingMachine.Button;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.charliesay.VendingMachine.Inventory.Item;

import java.math.BigDecimal;

import static uk.charliesay.VendingMachine.Button.CharacterButton.*;

public class ItemButtonTest {

    CharacterButton characterButton;
    NumberButton numberButton;
    Item testItemObject;
    ItemButton testItemButton;

    @Before
    public void setUp() {
        characterButton = new CharacterButton(availableCharacters.A);
        numberButton = new NumberButton(1);
        testItemObject = new Item(new BigDecimal(1.00), "Sprite");
        testItemButton = new ItemButton(characterButton, numberButton, testItemObject);
    }

    @Test
    public void should_CombineButtons_MakingFriendlyName() {
        String friendlyNameShouldBe = "A1";

        Assert.assertEquals(testItemButton.getFriendlyName(), friendlyNameShouldBe);
        Assert.assertEquals(testItemButton.getItem().getItemName(), testItemObject.getItemName());
        Assert.assertEquals(testItemButton.getNumberButton().getButtonID(), numberButton.getButtonID());
    }

    @Test
    public void should_SetButtonsTo_ItemButton() {
        Assert.assertEquals(characterButton.getCharacterValueAsChar(),
                testItemButton.getCharacterButton().getCharacterValueAsChar());
        Assert.assertEquals(numberButton.getButtonID(),
                testItemButton.getNumberButton().getButtonID());
        Assert.assertEquals(testItemObject.getItemName(),
                testItemButton.getItem().getItemName());
    }

}