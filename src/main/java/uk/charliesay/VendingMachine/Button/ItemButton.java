package uk.charliesay.VendingMachine.Button;

import uk.charliesay.VendingMachine.Inventory.Item;

public class ItemButton extends Button {

    private String friendlyName;
    private CharacterButton characterButton;
    private NumberButton numberButton;
    private Item item;

    public ItemButton(CharacterButton characterButton, NumberButton numberButton, Item item) {
        this.characterButton = characterButton;
        this.numberButton = numberButton;
        this.item = item;
            friendlyName = (characterButton.getCharacterValueAsChar()+numberButton.getButtonID().toString());
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public CharacterButton getCharacterButton() {
        return characterButton;
    }

    public NumberButton getNumberButton() {
        return numberButton;
    }

    public Item getItem() {
        return item;
    }


}
