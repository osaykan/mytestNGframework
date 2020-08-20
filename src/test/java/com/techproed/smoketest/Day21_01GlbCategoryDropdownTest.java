package com.techproed.smoketest;

import com.techproed.pages.GlbHomePage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day21_01GlbCategoryDropdownTest {
    //Kullanıcı https://www.glbtrader.com/ adresine gittiğinde
    //All Categories dropdown elementinde Furniture seçeneğinin bulunduğunu doğrulayın.
    //Adım 1: Page objelerini oluşturmak için GlbHomePage'i kullanabilirsiniz.
    //Adım 2: Test classı oluşturun GlbCategoryDropdownTest
    @Test
    public void glbDropdawnTest(){
        Driver.getDriver().get((ConfigurationReader.getProperty("glb_url")));
        GlbHomePage glbHomePage=new GlbHomePage();

        Select options = new Select(glbHomePage.allCatagoriesDropdown);
        boolean flag=false;
        for(WebElement option: options.getOptions()){
            if(option.getText().equals("Furniture")){
                System.out.println("Dropdownda Furniture vardir.");
                flag=true;
                break;
            }
        }

        Assert.assertTrue(flag);
        Driver.closeDriver();

    }

}
