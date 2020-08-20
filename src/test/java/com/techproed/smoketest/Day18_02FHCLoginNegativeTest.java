package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day18_02FHCLoginNegativeTest extends TestBase {
    ////Username : manager2
    ////Password : Man1ager2!


    @Test
    public void gecersizUsername(){
        driver.get("http://www.fhctrip.com/Account/Logon");
        FHCLoginPage fhcLoginPage=new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys("mana");
        fhcLoginPage.password.sendKeys("Man1ager2!");
        fhcLoginPage.loginButton.click();
        WebDriverWait wait=new WebDriverWait(driver,10);

        Assert.assertTrue(fhcLoginPage.errormesaj.isDisplayed());
    }
    @Test
    public void gecersizPassword(){
        driver.get("http://www.fhctrip.com/Account/Logon");
        FHCLoginPage fhcLoginPage=new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys("manager2");
        fhcLoginPage.password.sendKeys("Man1a");
        fhcLoginPage.loginButton.click();
        Assert.assertTrue(fhcLoginPage.errormesaj.isDisplayed());
    }
    @Test
    public void gecersizUsernamePassword(){
        driver.get("http://www.fhctrip.com/Account/Logon");
        FHCLoginPage fhcLoginPage=new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys("manag");
        fhcLoginPage.password.sendKeys("Man1a");
        fhcLoginPage.loginButton.click();
        Assert.assertTrue(fhcLoginPage.errormesaj.isDisplayed());
    }

}
