package com.techproed.tests;

import com.techproed.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class Day13Tekrar extends TestBase {
    //Tests package’inda yeni bir class olusturun: WindowHandleExample
    //https://the-internet.herokuapp.com/windows adresine gidin.
    //Sayfadaki textin  “Opening a new window” olduğunu doğrulayın.
    //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //Click Here butonuna basın.
    //Acilan yeni pencerenin sayfa başlığının (title)  “New Window” oldugunu dogrulayin.
    //Sayfadaki textin   “New Window” olduğunu doğrulayın.
    //Bir önceki pencereye geri döndükten sonra sayfa başlığının  “The Internet” olduğunu doğrulayın.
    @Test
    public void windowHandle(){
        driver.get("https://the-internet.herokuapp.com/windows");
        String parentWindowHandle=driver.getWindowHandle();

        Assert.assertEquals(driver.findElement(By.xpath("//*[.='Opening a new window']")).getText(),"Opening a new window");
        Assert.assertEquals(driver.getTitle(),"The Internet");

        driver.findElement(By.linkText("Click Here")).click();
        Set<String> allWindowHandles= driver.getWindowHandles();

        for(String childWindow:allWindowHandles){
            if(!childWindow.equals(parentWindowHandle)){
                String childHandle=childWindow;
                driver.switchTo().window(childHandle);

            }
        }

        Assert.assertEquals(driver.getTitle(),"New Window");
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(),"New Window");
        driver.switchTo().window(parentWindowHandle);
        Assert.assertEquals(driver.getTitle(),"The Internet");
    }
}
