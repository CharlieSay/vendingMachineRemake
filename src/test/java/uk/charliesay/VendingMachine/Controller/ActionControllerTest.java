package uk.charliesay.VendingMachine.Controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.charliesay.VendingMachine.Button.CharacterButton;
import uk.charliesay.VendingMachine.Button.NumberButton;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ActionControllerTest {

    ActionController testActionController;
    VendingMachine vendingMachine;

    @Before
    public void setUp(){
        vendingMachine = new VendingMachine();
        testActionController = new ActionController(vendingMachine);
    }

    @Test
    public void should_ReturnFalse_NotStartingOrder_WhenOnlyOneButtonPressed(){
        CharacterButton characterButton = new CharacterButton(CharacterButton.availableCharacters.A);
        Assert.assertFalse(testActionController.ButtonPress(characterButton));
    }

    @Test
    public void should_ReturnTrue_WhenTwoButtonsHaveBeenPressedThenAnotherCreatingNewOrder(){
        CharacterButton characterButton = new CharacterButton(CharacterButton.availableCharacters.A);
        CharacterButton characterButton2 = new CharacterButton(CharacterButton.availableCharacters.A);
        NumberButton numberButton = new NumberButton(1);
        NumberButton numberButton2 = new NumberButton(2);

        Assert.assertFalse(testActionController.ButtonPress(characterButton));
        Assert.assertTrue(testActionController.ButtonPress(numberButton));
        Assert.assertFalse(testActionController.ButtonPress(characterButton2));
        Assert.assertTrue(testActionController.ButtonPress(numberButton2));
    }
    @Test
    public void should_ReturnTrue_WhenTwoButtonsHaveBeenPressed(){
        CharacterButton characterButton = new CharacterButton(CharacterButton.availableCharacters.A);
        NumberButton numberButton = new NumberButton(1);

        testActionController.ButtonPress(characterButton);

        Assert.assertTrue(testActionController.ButtonPress(numberButton));
    }

    @Test
    public void shouldKickOff_AddGivenAmount_ToMoneyStore(){
        testActionController.MoneyInsert(BigDecimal.valueOf(1.00).setScale(2, RoundingMode.CEILING));

        Assert.assertEquals("£1.00",vendingMachine.getMoneyStore().getCurrentAmountFormattedAsString());
    }

}