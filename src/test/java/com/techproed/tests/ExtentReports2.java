package com.techproed.tests;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExtentReports2 extends TestBaseFinal {

    @Test
    public void negativeTest(){
        extentTest= extentReports.createTest("FHC Login Test","FHC Login fonksiyonunun testi ");
      extentTest.info("url'e git");
        Driver.getDriver().get(ConfigurationReader.getProperty("fhc_login_url"));

        FHCLoginPage fhcLoginPage=new FHCLoginPage(Driver.getDriver());
        extentTest.info("gecersiz username gönder");
        fhcLoginPage.username.sendKeys(ConfigurationReader.getProperty("gecersiz_username"));
        extentTest.info("gecersiz password gönder");
        fhcLoginPage.password.sendKeys(ConfigurationReader.getProperty("gecersiz_password"));
        extentTest.info("login butonuna tikla");
        fhcLoginPage.loginButton.click();
        extentTest.info("assertion yap");
        Assert.assertTrue(fhcLoginPage.errormesaj.getText().contains("Try again please"));
        extentTest.info("PASSED: Try again please");
        Driver.closeDriver();
        extentTest.info("Driver kapatildi");


    }


}
