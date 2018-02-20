package uk.charliesay.VendingMachine.Button;

import org.junit.Assert;
import org.junit.Test;

import static uk.charliesay.VendingMachine.Button.CharacterButton.*;

public class CharacterButtonTest {

    CharacterButton characterButtonTestObject;

    @Test
    public void should_CreateCharacterObjectFromEnum_ThenReturnValueAsChar(){
        availableCharacters A = availableCharacters.A;
        characterButtonTestObject = new CharacterButton(A);

        Character shouldBe = 'A';

        Assert.assertEquals(shouldBe,characterButtonTestObject.getCharacterValueAsChar());
    }

    @Test
    public void should_CreateCharacterObjectFromEnum_ThenReturnAsEnumObject(){
        availableCharacters B = availableCharacters.B;
        characterButtonTestObject = new CharacterButton(B);

        Assert.assertEquals(B,characterButtonTestObject.getCharacterValue());
    }

}