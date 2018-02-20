package uk.charliesay.VendingMachine.Button;

public class CharacterButton extends Button {

    private availableCharacters characterValue;

    public CharacterButton(availableCharacters characterValue) {
        this.characterValue = characterValue;
    }

    public availableCharacters getCharacterValue() {
        return characterValue;
    }

    public Character getCharacterValueAsChar(){
        return characterValue.name().toCharArray()[0];
    }

    public enum availableCharacters {
        A, B, C, D, E;
    }

}
