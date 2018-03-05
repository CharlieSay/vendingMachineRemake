package uk.charliesay.VendingMachine.Controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.charliesay.VendingMachine.Button.CharacterButton;
import uk.charliesay.VendingMachine.Button.ItemButton;
import uk.charliesay.VendingMachine.Button.NumberButton;
import uk.charliesay.VendingMachine.Exceptions.PhysicalException;
import uk.charliesay.VendingMachine.Inventory.Item;

import java.math.BigDecimal;

import static uk.charliesay.VendingMachine.Button.CharacterButton.availableCharacters.*;

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
        boolean shouldBeFalse = orderController.OrderRequest(characterButton,numberButton,"cash");

        Assert.assertFalse(shouldBeFalse);
    }

    @Test
    public void should_ReturnFalse_WhenValidButtonCombination_ButNoFunds_CashPayment(){
        CharacterButton characterButton = new CharacterButton(CharacterButton.availableCharacters.A);
        NumberButton numberButton = new NumberButton(1);
        setUpFakeInventory();

        boolean shouldBeTrue = orderController.OrderRequest(characterButton,numberButton,"cash");

        Assert.assertFalse(shouldBeTrue);
    }

    @Test
    public void should_ReturnTrue_WhenValidCombination_ButWithFunds_CashPayment(){
        CharacterButton characterButton = new CharacterButton(CharacterButton.availableCharacters.A);
        NumberButton numberButton = new NumberButton(1);
        vendingMachine.getMoneyStore().addToStore(BigDecimal.valueOf(1.50));
        setUpFakeInventory();

        boolean shouldBeTrue = orderController.OrderRequest(characterButton,numberButton,"cash");

        Assert.assertTrue(shouldBeTrue);
    }

    @Test
    public void should_ReturnTrue_WhenValidCombination_CardContactlessPayment(){
        CharacterButton characterButton = new CharacterButton(CharacterButton.availableCharacters.A);
        NumberButton numberButton = new NumberButton(1);
        vendingMachine.getMoneyStore().addToStore(BigDecimal.valueOf(1.50));
        setUpFakeInventory();

        boolean shouldBeTrue = orderController.OrderRequest(characterButton,numberButton,"contactless");

        Assert.assertTrue(shouldBeTrue);
    }

    @Test
    public void should_ReturnTrue_WhenValidCombination_CardChipPinPayment(){
        CharacterButton characterButton = new CharacterButton(CharacterButton.availableCharacters.A);
        NumberButton numberButton = new NumberButton(1);
        vendingMachine.getMoneyStore().addToStore(BigDecimal.valueOf(1.50));
        setUpFakeInventory();

        boolean shouldBeTrue = orderController.OrderRequest(characterButton,numberButton,"chip");

        Assert.assertTrue(shouldBeTrue);
    }

    @Test
    public void should_ReturnTrue_WhenValidCombination_CardBTCPayment(){
        CharacterButton characterButton = new CharacterButton(CharacterButton.availableCharacters.A);
        NumberButton numberButton = new NumberButton(1);
        vendingMachine.getMoneyStore().addToStore(BigDecimal.valueOf(1.50));
        setUpFakeInventory();

        boolean shouldBeTrue = orderController.OrderRequest(characterButton,numberButton,"btc");

        Assert.assertTrue(shouldBeTrue);
    }

    @Test
    public void should_ReturnFalse_WhenValidCombiniation_ButInvalidPaymentType(){
        CharacterButton characterButton = new CharacterButton(CharacterButton.availableCharacters.A);
        NumberButton numberButton = new NumberButton(1);
        vendingMachine.getMoneyStore().addToStore(BigDecimal.valueOf(1.50));
        setUpFakeInventory();

        boolean shouldBeFalse = orderController.OrderRequest(characterButton,numberButton,"foobar");

        Assert.assertFalse(shouldBeFalse);
    }

    @Test
    public void should_ReturnFalse_IfItemIsNull(){
        Item nullItem = null;
        CharacterButton nullCharacterButton = new CharacterButton(C);
        NumberButton nullNumberButton = new NumberButton(1);
        ItemButton nullItemButton = new ItemButton(nullCharacterButton, nullNumberButton, nullItem);
        vendingMachine.getItemMap().addItemToList(nullItemButton,1);

        boolean shouldBeFalse = orderController.OrderRequest(nullCharacterButton,nullNumberButton,null);

        Assert.assertFalse(shouldBeFalse);
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