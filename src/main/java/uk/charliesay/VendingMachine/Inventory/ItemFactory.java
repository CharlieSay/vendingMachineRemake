package uk.charliesay.VendingMachine.Inventory;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ItemFactory {

    public Item ItemFactory(String name, Double price) {
        return new Item(BigDecimal.valueOf(price).setScale(2, RoundingMode.CEILING), name);
    }

}