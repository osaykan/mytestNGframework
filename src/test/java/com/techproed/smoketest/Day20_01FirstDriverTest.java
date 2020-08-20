package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day20_01FirstDriverTest {  //exstends yapmiyoruz. driver in yerine class ismiyle cagiracagiz


    @Test
    public void gecersizPassword(){
        //driver==>Driver.getDriver()  kullaniyoruz
       Driver.getDriver().get(ConfigurationReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage=new FHCLoginPage(Driver.getDriver());
        fhcLoginPage.username.sendKeys(ConfigurationReader.getProperty("gecerli_username"));
        fhcLoginPage.password.sendKeys(ConfigurationReader.getProperty("gecersiz_password"));
        fhcLoginPage.loginButton.click();
        Assert.assertTrue(fhcLoginPage.errormesaj.isDisplayed());
    }
}
