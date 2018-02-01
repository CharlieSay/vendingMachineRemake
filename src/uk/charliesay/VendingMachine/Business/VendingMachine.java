package uk.charliesay.VendingMachine.Business;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class VendingMachine {

    private void serialise() throws IOException {
        FileOutputStream fout = new FileOutputStream("res/itemList.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject("Test");
        fout.close();
        oos.close();
    }

    public boolean turnOn(){
        try{
            serialise();
            return true;
        }catch(IOException e){
            return false;
        }
    }

}
