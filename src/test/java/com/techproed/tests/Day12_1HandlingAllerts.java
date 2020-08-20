package com.techproed.tests;

import com.techproed.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day12_1HandlingAllerts extends TestBase {
    //Accept alert==>Ok
    //Dismis alert==>Cansel
    //accept()=> Ok                        driver.switchTo().allert().accept();
    //dismiss()=> Cancel demek             driver.switchTo().allert().dismiss();
    //getText()=>uyaridaki mesaji almak    driver.switchTo().allert().getText();

    //Bir class olusturun: HandlingAlerts
    //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.


    //Bir metod olusturun: acceptAlert
    //1. butona tıklayın, uyarıdaki(alert) OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
    @Test
    public void acceptAllert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement buton1 = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        buton1.click();

        //Alert üzerindeki mesaji konsolda yazdiralim
        System.out.println("Alert mesaji: "+driver.switchTo().alert().getText());//accept() ten önce yaz
        driver.switchTo().alert().accept();

        WebElement resultMesaj=driver.findElement(By.cssSelector("#result"));
        Assert.assertTrue(resultMesaj.isDisplayed());  //Hard assert

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);



    }
    //Bir metod olusturun: dismissAlert
    //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
    @Test
    public void dismissAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement buton2 = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        buton2.click();
        //uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss();   //dismiss() cancel methoduna basmak demektir

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //result mesajının görüntülendiğini doğrulayın.
        WebElement resultMesj=driver.findElement(By.cssSelector("#result"));
        Assert.assertTrue(resultMesj.isDisplayed());

    }
    //Bir metod olusturun: sendKeysAlert
    //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
    @Test
    public void sendKeysAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement buton3 = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        buton3.click();

        // uyarıdaki metin kutusuna isminizi yazin
        driver.switchTo().alert().sendKeys("Osman");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //OK butonuna tıklayın
        driver.switchTo().alert().accept();

        WebElement resultMesaj= driver.findElement(By.cssSelector("#result"));
        Assert.assertTrue(resultMesaj.isDisplayed());



    }
}
