package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Day13_02WindowHandleExample extends TestBase {
    //Tests package’inda yeni bir class olusturun: WindowHandleExample
    //https://the-internet.herokuapp.com/windows adresine gidin.
    //Sayfadaki textin  “Opening a new window” olduğunu doğrulayın.
    //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //Click Here butonuna basın.
    //Acilan yeni pencerenin sayfa başlığının (title)  “New Window” oldugunu dogrulayin.
    //Sayfadaki textin   “New Window” olduğunu doğrulayın.
    //Bir önceki pencereye geri döndükten sonra sayfa başlığının  “The Internet” olduğunu doğrulayın.

    @Test
    public void newWindowTest(){
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement text= driver.findElement(By.xpath("//*[.='Opening a new window']"));
        String parentWindowHandle=driver.getWindowHandle();
        System.out.println("Parent Window Handle==> "+parentWindowHandle);//Alfanümerik ID

        //Sayfadaki textin  “Opening a new window” olduğunu doğrulayın.
        String actualtext= text.getText();
        String expectedtext="Opening a new window";
        Assert.assertEquals(actualtext,expectedtext);
        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle=driver.getTitle();
        String expectedTitle="The Internet";
        Assert.assertEquals(actualTitle,expectedTitle);
        //Click Here butonuna basın.
        WebElement clickbuton=driver.findElement(By.linkText("Click Here"));
        clickbuton.click();
        //Acilan yeni pencerenin sayfa başlığının (title)  “New Window” oldugunu dogrulayin.
        //Diger sekmeye gecmeliyiz. Ilkönce bir set() olusturacagiz.

        Set<String> allWindowHandles= driver.getWindowHandles();
        for (String childWindowHandle : allWindowHandles) {
            if(!childWindowHandle.equals(parentWindowHandle)){
                driver.switchTo().window(childWindowHandle);             //gecis yaptik
                System.out.println("Child Window Handle ==>"+childWindowHandle);

            }

        }

            String actualChildTitle=driver.getTitle();
            String expectedChildTitle="New Window";
        System.out.println("Child Title==> "+actualChildTitle);
            Assert.assertEquals(actualChildTitle,expectedChildTitle);
        //Sayfadaki textin   “New Window” olduğunu doğrulayın.
        String newWindowText=driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(newWindowText,"New Window");

        //Bir önceki pencereye geri döndükten sonra sayfa başlığının  “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(parentWindowHandle);
        String actualYeniParentTitle= driver.getTitle();
        String expectedYeniParentTitle="The Internet";
        System.out.println("Yeni Title ==>"+actualYeniParentTitle);
        Assert.assertEquals(actualYeniParentTitle,expectedYeniParentTitle);




    }

}
