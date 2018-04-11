package uk.charliesay.VendingMachine.Controller;

import uk.charliesay.VendingMachine.Button.CharacterButton;
import uk.charliesay.VendingMachine.Button.ItemButton;
import uk.charliesay.VendingMachine.Button.NumberButton;
import uk.charliesay.VendingMachine.Inventory.Item;
import uk.charliesay.VendingMachine.Inventory.ItemFactory;

import java.util.logging.Level;
import java.util.logging.Logger;

public class  PowerController {

    private final ItemFactory itemFactory = new ItemFactory();
    VendingMachine vendingMachine;

    public static void main(String[] args) {
        PowerController powerController = new PowerController();
        powerController.turnOn();
    }

    public PowerController(){
        this.turnOn();
    }

    /*
    Kicks off whole machine process, populates inventory.
     */

    public void turnOn(){
        Logger.getGlobal().log(Level.INFO," Turning On..");
        vendingMachine = new VendingMachine();
        inventoryPopulation();
        idle();
    }

    /*
    Turns off safely
     */

    public void turnOff(){
        vendingMachine = null;
        Logger.getGlobal().log(Level.INFO," Turning Off...");
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

        Item spriteItem = itemFactory.ItemFactory("Sprite", 1.00);
        Item drPepperItem = itemFactory.ItemFactory("Dr Pepper", 1.00);
        Item cokeItem = itemFactory.ItemFactory("Coke", 1.00);
        Item cokeCherryItem = itemFactory.ItemFactory("Coke Cherry", 1.00);
        Item fantaItem = itemFactory.ItemFactory("Fanta", 1.00);
        Item waterItem = itemFactory.ItemFactory("Water", 0.50);
        Item fizzyWaterItem = itemFactory.ItemFactory("Fizzy Water", 0.80);
        Item ribenaItem = itemFactory.ItemFactory("Ribena", 1.20);
        Item yazooItem = itemFactory.ItemFactory("Yazoo", 0.80);

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
