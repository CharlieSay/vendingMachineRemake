package uk.charliesay.VendingMachine.Money.PaymentTypes;

import uk.charliesay.VendingMachine.Money.Payment;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

public class BitcoinPayment extends Payment {

    private final String bitcoinAddress = "1PZavzxGifgAWoLSkDbRaPwDHdqtFD7CXk";
    private final String hashAddress = "f77c66f73a007b67a46e47250f40ee2c71b3bcea";

    @Override
    public boolean makePayment() {
        qrCodeDisplay();
        return true;
    }


    public String[] walletDetails(){
        String[] walletDetails = new String[2];
        walletDetails[0] = bitcoinAddress;
        walletDetails[1] = hashAddress;
        return walletDetails;
    }

    public ImageIcon qrCodeObject(){
        try {
            URL url = new URL("https://blockchain.info/qr?data=1PZavzxGifgAWoLSkDbRaPwDHdqtFD7CXk&size=200");
            BufferedImage image = ImageIO.read(url);
            return new ImageIcon(image);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void qrCodeDisplay(){
       JLabel label = new JLabel(qrCodeObject());
       JFrame frame = new JFrame();
       frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       frame.getContentPane().add(label);
       frame.pack();
       frame.setLocation(200,200);
       frame.setResizable(false);
       frame.setVisible(true);
       }

}

