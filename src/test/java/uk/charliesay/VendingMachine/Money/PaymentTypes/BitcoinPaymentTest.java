package uk.charliesay.VendingMachine.Money.PaymentTypes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import javax.swing.*;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BitcoinPaymentTest {

    BitcoinPayment bitcoinPayment = new BitcoinPayment();

    @Before
    public void setUp(){
        bitcoinPayment = new BitcoinPayment();
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
    public void test(){
        Assert.assertTrue(bitcoinPayment.makePayment());
    }
}