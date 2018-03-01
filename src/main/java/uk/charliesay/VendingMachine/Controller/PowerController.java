package uk.charliesay.VendingMachine.Controller;

public class PowerController {

    VendingMachine vendingMachine = new VendingMachine();

    public static void main(String[] args) {
        PowerController powerController = new PowerController();
        powerController.turnOn();
    }

    private static void turnOn(){
        //Pretend get config, of display, inventory... etc....
    }

    private static void turnOff(){

    }

    public static void idle(){

    }
}
