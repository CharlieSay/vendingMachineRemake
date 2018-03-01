package uk.charliesay.VendingMachine.Controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.charliesay.VendingMachine.Button.CharacterButton;
import uk.charliesay.VendingMachine.Button.ItemButton;
import uk.charliesay.VendingMachine.Button.NumberButton;
import uk.charliesay.VendingMachine.Inventory.Item;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static uk.charliesay.VendingMachine.Button.CharacterButton.availableCharacters.A;
import static uk.charliesay.VendingMachine.Button.CharacterButton.availableCharacters.B;

public class OrderControllerTest {

    private OrderController orderController;
    private VendingMachine vendingMachine;

    @Before
    public void setUp(){
        vendingMachine = new VendingMachine();
        orderController = new OrderController(vendingMachine);
    }

    @Test
    public void should_NotBeNull_WhenConstructed(){
        Assert.assertNotNull(orderController);
    }

    @Test
    public void should_ReturnFalse_WhenInvalidButtonCombination(){
        CharacterButton characterButton = new CharacterButton(CharacterButton.availableCharacters.E);
        NumberButton numberButton = new NumberButton(9);
        boolean shouldBeFalse = orderController.OrderRequest(characterButton,numberButton);

        Assert.assertFalse(shouldBeFalse);
    }

    @Test
    public void should_ReturnFalse_WhenValidButtonCombination_ButNoFunds(){
        CharacterButton characterButton = new CharacterButton(CharacterButton.availableCharacters.A);
        NumberButton numberButton = new NumberButton(1);
        setUpFakeInventory();

        boolean shouldBeTrue = orderController.OrderRequest(characterButton,numberButton);

        Assert.assertFalse(shouldBeTrue);
    }

    @Test
    public void should_ReturnTrue_WhenValidCombination_ButWithFunds(){
        CharacterButton characterButton = new CharacterButton(CharacterButton.availableCharacters.A);
        NumberButton numberButton = new NumberButton(1);
        vendingMachine.getMoneyStore().addToStore(BigDecimal.valueOf(1.50));
        setUpFakeInventory();

        boolean shouldBeTrue = orderController.OrderRequest(characterButton,numberButton);

        Assert.assertTrue(shouldBeTrue);
    }

    private void setUpFakeInventory(){
        Item sprite = new Item(new BigDecimal(1.00), "Sprite");
        CharacterButton spriteCharacterButton = new CharacterButton(A);
        NumberButton spriteNumberButton = new NumberButton(1);
        ItemButton spriteItemButton = new ItemButton(spriteCharacterButton, spriteNumberButton, sprite);
        Item water = new Item(new BigDecimal(0.50), "Water");
        CharacterButton waterCharacterButton = new CharacterButton(B);
        NumberButton waterNumberButton = new NumberButton(1);
        ItemButton waterItemButton = new ItemButton(waterCharacterButton, waterNumberButton, water);

        vendingMachine.getItemMap().addItemToList(spriteItemButton, 10);
        vendingMachine.getItemMap().addItemToList(waterItemButton, 10);
    }
}