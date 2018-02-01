package uk.charliesay.VendingMachine.Business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineTest {

    private VendingMachine vendingMachine;

    @Before
    public void setUp(){
        vendingMachine = new VendingMachine();
    }

    @Test
    public void whenTurnOnIsCalled_ShouldReturnTrue(){
        boolean testResult = vendingMachine.turnOn();

        Assert.fail();
        assertTrue(testResult);
    }

    @Test
    public void ExceptionCatcher(){
        boolean testResult = vendingMachine.turnOn();
        assertTrue(!testResult);
    }


}