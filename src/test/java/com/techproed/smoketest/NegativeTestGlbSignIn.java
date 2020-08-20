package com.techproed.smoketest;

import com.techproed.pages.GlbSignInPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTestGlbSignIn {
    @Test
    public void negativeTestGlbSignIn(){
        Driver.getDriver().get(ConfigurationReader.getProperty("glb_signin_url"));

        GlbSignInPage glbSignInPage = new GlbSignInPage();
        glbSignInPage.email.sendKeys(ConfigurationReader.getProperty("test_email"));
        glbSignInPage.password.sendKeys(ConfigurationReader.getProperty("gecersiz_password"));
        glbSignInPage.loginButton.click();

        Assert.assertTrue(glbSignInPage.mesaj.isDisplayed());

        Driver.closeDriver();

    }
}
