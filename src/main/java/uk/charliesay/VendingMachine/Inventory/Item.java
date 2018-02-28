package uk.charliesay.VendingMachine.Inventory;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Item {

    private BigDecimal absolutePrice;
    private String itemName;

    public Item(BigDecimal absolutePrice, String itemName) {
        this.absolutePrice = absolutePrice.setScale(2, RoundingMode.CEILING);
        this.itemName = itemName;
    }

    public String getFriendlyDetails(){
        return ("Item Name : "+ itemName +" Item Price : " + absolutePrice.toString());
    }

    public BigDecimal getAbsolutePrice() {
        return absolutePrice;
    }

    public String getItemName() {
        return itemName;
    }
}
