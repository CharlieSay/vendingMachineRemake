package uk.charliesay.VendingMachine.Money.PaymentTypes;

import org.json.JSONObject;
import uk.charliesay.VendingMachine.Money.Payment;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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

    public JSONObject currentExchangeRate(){
        try {
            URL url = new URL("http://api.coindesk.com/v1/bpi/currentprice.json");
            URLConnection urlConnection = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null){
                sb.append(inputLine);
            }
            in.close();
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void qrCodeDisplay() {
        JLabel label = new JLabel(qrCodeObject());
        JFrame frame = new JFrame();
        JLabel currentPrice = new JLabel("Current BTC Price : £5438.90");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.getContentPane().add(currentPrice, BorderLayout.NORTH);
        frame.pack();
        frame.setLocation(200, 200);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public BigDecimal getAmountToPay() {
        return amountToPay;
    }

}

