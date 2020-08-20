package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day19_01NegativeTest extends TestBase {
    ////Username : manager2
    ////Password : Man1ager2!


    @Test
    public void gecersizUsername(){  //http://www.fhctrip.com/Account/Logon"
        driver.get(ConfigurationReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage=new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys(ConfigurationReader.getProperty("gecersiz_username"));
        fhcLoginPage.password.sendKeys(ConfigurationReader.getProperty("gecerli_password"));
        fhcLoginPage.loginButton.click();

        Assert.assertTrue(fhcLoginPage.errormesaj.getText().contains(ConfigurationReader.getProperty("login_error_mesaj")));
        //Assert.assertTrue(fhcLoginPage.errormesaj.isDisplayed());
    }
    @Test
    public void gecersizPassword(){
        driver.get(ConfigurationReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage=new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys(ConfigurationReader.getProperty("gecerli_username"));
        fhcLoginPage.password.sendKeys(ConfigurationReader.getProperty("gecersiz_password"));
        fhcLoginPage.loginButton.click();
        Assert.assertTrue(fhcLoginPage.errormesaj.isDisplayed());
    }
    @Test
    public void gecersizUsernamePassword(){
        driver.get(ConfigurationReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage=new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys(ConfigurationReader.getProperty("gecersiz_username"));
        fhcLoginPage.password.sendKeys(ConfigurationReader.getProperty("gecersiz_password"));
        fhcLoginPage.loginButton.click();
        Assert.assertTrue(fhcLoginPage.errormesaj.isDisplayed());
    }
}
