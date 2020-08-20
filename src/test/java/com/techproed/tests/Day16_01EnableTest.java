package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day16_01EnableTest extends TestBase {
    //	Bir class olusturun : EnableTest
    //2.	Bir metod olusturun :  isEnabled()
    //3.	https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4.	Enable butonuna basin.
    //5.	Textbox’in etkin olup olmadigini(enabled) dogrulayin.
    //6.	“It’s enabled!” mesajinin goruntulendigini dogrulayin.

    @Test
    public  void isEnabled(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4.	Enable butonuna basin.
        WebElement enableButton= driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        enableButton.click();

        //6.	“It's enabled!” mesajinin goruntulendigini dogrulayin.  önce bu gözükürse alltaki zaten olur
        //explicit wait gerekli yükleme icin zaman gerekli ve belli bir kosul var
        WebDriverWait wait=new WebDriverWait(driver,10);
        WebElement enableMesaj=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertEquals(enableMesaj.getText(),"It's enabled!");


        //5.	Textbox’in etkin olup olmadigini(enabled) dogrulayin.
        WebElement textBox=driver.findElement(By.xpath("//input[@type='text']"));
     boolean isEnable=   textBox.isEnabled();     //true veya False   isEnable aktif olup olmadigi
        Assert.assertTrue(isEnable);

        //isEnabled();==> Bir elementin etkin olup olmadigini kontrol eder
        //isDisplayed();==> Bir elementin görünüp görünmedigini kontrol eder
        //isSelected();==> radio button ve checkbox secilmismi


    }
}
