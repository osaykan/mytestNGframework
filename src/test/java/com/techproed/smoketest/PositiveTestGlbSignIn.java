package com.techproed.smoketest;

import com.techproed.pages.GlbSignInPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTestGlbSignIn {
    //Global Trader Sign In Test.
    //Kullanici https://www.glbtrader.com/login.html sayfasina gitsin.
    //Sayfaya dogru ve yanlis veriler girerek sign in ozelligini test etsin.
    //pages  paketinin altina bir page class olusturun : GlbSignInPage
    //Page objelerini(webelement) bulun.
    //smoketest  paketinin altina iki tane test classi olusturun :
    //PositiveTestGlbSignIn
    //NegativeTestGlbSignIn

    @Test
    public void positiveTestGlbSignIn(){
       Driver.getDriver().get(ConfigurationReader.getProperty("glb_signin_url"));

        GlbSignInPage glbSignInPage = new GlbSignInPage();
        glbSignInPage.email.sendKeys(ConfigurationReader.getProperty("test_email"));
        glbSignInPage.password.sendKeys(ConfigurationReader.getProperty("test_password"));
        glbSignInPage.loginButton.click();

        Assert.assertTrue(glbSignInPage.myAccount.isDisplayed());

    }
}
