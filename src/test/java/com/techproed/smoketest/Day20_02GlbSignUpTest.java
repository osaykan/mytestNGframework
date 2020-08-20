package com.techproed.smoketest;

import com.techproed.pages.GlbHomePage;
import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day20_02GlbSignUpTest {


    GlbSignUpPage glbSignUpPage = new GlbSignUpPage();
    GlbHomePage glbHomePage=new GlbHomePage();    //21 gün bu objeyi olusturduk. Iki farkli classtan cagri yapiyoruz
    @Test
    public void signUpTest() throws InterruptedException {
        //driver==>Driver.getDrive()

        //Driver.getDriver().get(ConfigReader.getProperty("glb_signup_url"));   sonradan degistirdik 21.gün alt iki satiri yazdik

        Driver.getDriver().get(ConfigurationReader.getProperty("glb_url"));
        glbHomePage.joinNowLink.click();

        glbSignUpPage.email.sendKeys(ConfigurationReader.getProperty("test_email"));
        glbSignUpPage.name.sendKeys(ConfigurationReader.getProperty("test_username"));
        glbSignUpPage.phone.sendKeys(ConfigurationReader.getProperty("test_phone"));
        glbSignUpPage.password.sendKeys(ConfigurationReader.getProperty("test_password"));
        glbSignUpPage.repassword.sendKeys(ConfigurationReader.getProperty("test_password"));

        glbSignUpPage.signUpButton.click();
        Thread.sleep(3000);
        Assert.assertTrue(glbSignUpPage.successMesaj.getText().equals("Success!"));
        //Test fail olacak cunkü actual Success! ! fakat expected Success!

        Driver.closeDriver();

    }
}
