package uk.charliesay.VendingMachine.Money.PaymentTypes;

import uk.charliesay.VendingMachine.Money.Payment;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
To Implement current rate of BTC/USD Against price of ITEM.
 */

public class BitcoinPayment extends Payment {

    private final String bitcoinAddress = "1PZavzxGifgAWoLSkDbRaPwDHdqtFD7CXk";
    private final String hashAddress = "f77c66f73a007b67a46e47250f40ee2c71b3bcea";

    private BigDecimal amountToPay;

    @Override
    public boolean makePayment() {
        qrCodeDisplay();
        return true;
    }

    public BitcoinPayment(BigDecimal amountToPay) {
        this.amountToPay = amountToPay;
        makePayment();
    }

    public String[] walletDetails() {
        String[] walletDetails = new String[2];
        walletDetails[0] = bitcoinAddress;
        walletDetails[1] = hashAddress;
        return walletDetails;
    }

    public ImageIcon qrCodeObject() {
        try {
            URL url = new URL("https://blockchain.info/qr?data=1PZavzxGifgAWoLSkDbRaPwDHdqtFD7CXk&size=200");
            BufferedImage image = ImageIO.read(url);
            return new ImageIcon(image);
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE,"Something went wrong",e);
            return null;
        }
    }

    private void qrCodeDisplay() {
        JLabel label = new JLabel(qrCodeObject());
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.getContentPane().add(label);
        frame.pack();
        frame.setLocation(200, 200);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public BigDecimal getAmountToPay() {
        return amountToPay;
    }

}

