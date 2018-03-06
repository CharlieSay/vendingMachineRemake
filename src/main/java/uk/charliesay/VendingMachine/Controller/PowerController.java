package uk.charliesay.VendingMachine.Controller;

import uk.charliesay.VendingMachine.Button.CharacterButton;
import uk.charliesay.VendingMachine.Button.ItemButton;
import uk.charliesay.VendingMachine.Button.NumberButton;
import uk.charliesay.VendingMachine.Inventory.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PowerController {

    VendingMachine vendingMachine;

    public static void main(String[] args) {
        PowerController powerController = new PowerController();
        powerController.turnOn();
    }

    /*
    Kicks off whole machine process, populates inventory.
     */

    private void turnOn(){
        vendingMachine = new VendingMachine();
        inventoryPopulation();
        idle();
    }

    /*
    Turns off safely
     */

    private void turnOff(){
        vendingMachine = null;
    }

    /*
    Pretend idle state
     */

    public static void idle(){
        Logger.getGlobal().log(Level.INFO," Waiting....");
    }

    private void inventoryPopulation(){
        CharacterButton spriteCharacterButton = new CharacterButton(CharacterButton.availableCharacters.A);
        CharacterButton drPepperCharacterButton = new CharacterButton(CharacterButton.availableCharacters.A);
        CharacterButton cokeCharacterButton = new CharacterButton(CharacterButton.availableCharacters.A);
        CharacterButton cokeCherryCharacterButton = new CharacterButton(CharacterButton.availableCharacters.B);
        CharacterButton fantaCharacterButton = new CharacterButton(CharacterButton.availableCharacters.B);
        CharacterButton waterCharacterButton = new CharacterButton(CharacterButton.availableCharacters.B);
        CharacterButton ribenaCharacterButton = new CharacterButton(CharacterButton.availableCharacters.C);
        CharacterButton fizzyWaterCharacterButton = new CharacterButton(CharacterButton.availableCharacters.C);
        CharacterButton yazooCharacterButton = new CharacterButton(CharacterButton.availableCharacters.C);

        NumberButton spriteNumberButton = new NumberButton(1);
        NumberButton drPepperNumberButton = new NumberButton(2);
        NumberButton cokeNumberButton = new NumberButton(3);
        NumberButton cokeCherryNumberButton = new NumberButton(1);
        NumberButton fantaNumberButton = new NumberButton(2);
        NumberButton waterNumberButton = new NumberButton(3);
        NumberButton ribenaNumberButton = new NumberButton(1);
        NumberButton fizzyWaterNumberButton = new NumberButton(2);
        NumberButton yazooNumberButton = new NumberButton(3);

        Item spriteItem = new Item(BigDecimal.valueOf(1.00).setScale(2, RoundingMode.CEILING),"Sprite");
        Item drPepperItem = new Item(BigDecimal.valueOf(1.00).setScale(2, RoundingMode.CEILING),"Dr Pepper");
        Item cokeItem = new Item(BigDecimal.valueOf(1.00).setScale(2, RoundingMode.CEILING),"Coke");
        Item cokeCherryItem = new Item(BigDecimal.valueOf(1.00).setScale(2, RoundingMode.CEILING),"Coke Cherry");
        Item fantaItem = new Item(BigDecimal.valueOf(1.00).setScale(2, RoundingMode.CEILING),"Fanta");
        Item waterItem = new Item(BigDecimal.valueOf(0.50).setScale(2, RoundingMode.CEILING),"Water");
        Item ribenaItem = new Item(BigDecimal.valueOf(1.20).setScale(2, RoundingMode.CEILING),"Ribena");
        Item fizzyWaterItem = new Item(BigDecimal.valueOf(0.80).setScale(2, RoundingMode.CEILING),"Fizzy Water");
        Item yazooItem = new Item(BigDecimal.valueOf(0.80).setScale(2, RoundingMode.CEILING),"Yazoo");

        ItemButton spriteItemButton = new ItemButton(spriteCharacterButton,spriteNumberButton,spriteItem);
        ItemButton drPepperItemButton = new ItemButton(drPepperCharacterButton,drPepperNumberButton,drPepperItem);
        ItemButton cokeItemButton = new ItemButton(cokeCharacterButton,cokeNumberButton,cokeItem);
        ItemButton cokeCherryItemButton = new ItemButton(cokeCherryCharacterButton,cokeCherryNumberButton,cokeCherryItem);
        ItemButton fantaItemButton = new ItemButton(fantaCharacterButton,fantaNumberButton,fantaItem);
        ItemButton waterItemButton = new ItemButton(waterCharacterButton,waterNumberButton,waterItem);
        ItemButton ribenaItemButton = new ItemButton(ribenaCharacterButton,ribenaNumberButton,ribenaItem);
        ItemButton fizzyWaterItemButton = new ItemButton(fizzyWaterCharacterButton,fizzyWaterNumberButton,fizzyWaterItem);
        ItemButton yazooItemButton = new ItemButton(yazooCharacterButton,yazooNumberButton,yazooItem);

        vendingMachine.getItemMap().addItemToList(spriteItemButton,8);
        vendingMachine.getItemMap().addItemToList(drPepperItemButton,8);
        vendingMachine.getItemMap().addItemToList(cokeItemButton,8);
        vendingMachine.getItemMap().addItemToList(cokeCherryItemButton,8);
        vendingMachine.getItemMap().addItemToList(fantaItemButton,8);
        vendingMachine.getItemMap().addItemToList(waterItemButton,12);
        vendingMachine.getItemMap().addItemToList(ribenaItemButton,10);
        vendingMachine.getItemMap().addItemToList(fizzyWaterItemButton,12);
        vendingMachine.getItemMap().addItemToList(yazooItemButton,6);
    }
}
