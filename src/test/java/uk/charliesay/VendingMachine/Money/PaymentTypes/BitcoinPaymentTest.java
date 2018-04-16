package uk.charliesay.VendingMachine.Money.PaymentTypes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import javax.swing.*;
import java.math.BigDecimal;

public class BitcoinPaymentTest {

    BitcoinPayment bitcoinPayment;

    @Before
    public void setUp(){
        bitcoinPayment = new BitcoinPayment(new BigDecimal(1.00));
    }

    @Test
    public void localQRCode_ShouldReturnSameDimensionsAsRemoteQRCodeForWallet_WhenProvidedExternalURL(){
        ImageIcon urlQRCode = bitcoinPayment.qrCodeObject();
        ImageIcon localQRCode = new ImageIcon(getClass().getClassLoader().getResource("images/qrcode.png"));

        int urlQRCodeIconWidth = urlQRCode.getIconWidth();
        int localQRCodeIconWidth = localQRCode.getIconWidth();

        int urlQRCodeIconHeight = urlQRCode.getIconHeight();
        int localQRCodeIconHeight = localQRCode.getIconHeight();

        Assert.assertEquals(localQRCodeIconWidth,urlQRCodeIconWidth);
        Assert.assertEquals(urlQRCodeIconHeight,localQRCodeIconHeight);
    }

    @Test
    public void should_ReturnHardcodedBTCWalletDetails_WhenCalled(){
        String testCaseBitcoinAddress = "1PZavzxGifgAWoLSkDbRaPwDHdqtFD7CXk";
        String testCaseHashAddress = "f77c66f73a007b67a46e47250f40ee2c71b3bcea";

        String[] resultWalletArray = bitcoinPayment.walletDetails();
        String resultBitcoinAddress = resultWalletArray[0];
        String resultHashAddress = resultWalletArray[1];

        Assert.assertEquals(resultBitcoinAddress,testCaseBitcoinAddress);
        Assert.assertEquals(resultHashAddress,testCaseHashAddress);
    }

    @Test
    public void should_ConvertToBTC(){
        bitcoinPayment.currentExchangeRate();
    }

    @Test
    public void should_ReturnTrueonMakePayment(){
        Assert.assertTrue(bitcoinPayment.makePayment());
    }
}