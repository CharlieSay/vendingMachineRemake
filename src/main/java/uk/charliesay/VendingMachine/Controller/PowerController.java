package uk.charliesay.VendingMachine.Controller;

public class PowerController {

    VendingMachine vendingMachine;

    public static void main(String[] args) {
        PowerController powerController = new PowerController();
        powerController.turnOn();
        powerController.turnOff();
    }

    private void turnOn(){
        //Pretend get config, of display, inventory... etc....
        vendingMachine = new VendingMachine();
    }

    private void turnOff(){
        //Pretend turn off
    }

    public static void idle(){
        //Pretend 'idle' state
    }
}
