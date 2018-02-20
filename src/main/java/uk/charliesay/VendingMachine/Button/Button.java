package uk.charliesay.VendingMachine.Button;

public abstract class Button {
    public Integer getButtonID() {
        return buttonID;
    }

    public void setButtonID(Integer buttonID) {
        this.buttonID = buttonID;
    }

    private Integer buttonID;
}
