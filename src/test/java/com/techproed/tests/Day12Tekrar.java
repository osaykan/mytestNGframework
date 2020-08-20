package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day12Tekrar extends TestBase {
    //Bir class olusturun: HandlingAlerts
    //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //Bir metod olusturun: acceptAlert
    //1. butona tıklayın, uyarıdaki(alert) OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
    //Alert üzerindeki mesaji konsolda yazdiralim

    //Bir metod olusturun: dismissAlert
    //2. butona tıklayın
    //uyarıdaki Cancel butonuna tıklayın
    //result mesajının görüntülendiğini doğrulayın.

    //Bir metod olusturun: sendKeysAlert
    //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
    // OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.


    @Test
    public void acceptAllerts()  {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        button1.click();

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        WebElement result=driver.findElement(By.id("result"));

        Assert.assertTrue(result.isDisplayed());
    }
    @Test
    public void dismissAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement button2 = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        button2.click();

        System.out.println( driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        Assert.assertTrue(driver.findElement(By.id("result")).isDisplayed());


    }
    @Test
    public void sendKeysAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement button3 = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        button3.click();

        driver.switchTo().alert().sendKeys("Osman");
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(By.id("result")).isDisplayed());



    }
    //https://the-internet.herokuapp.com/iframe  adresine gidin.
    //Bir metod olusturun: iframeTest
    //“An IFrame containing….” textini konsolda yazdirin
    //Text Box’a “Merhaba Dunya!” yazin.
    // WebElement textBox = driver.findElement(By.xpath("//p")); //FAIL
    //textBox.sendKeys("Merhaba Dunya!");  test fail oldu

    //TextBox’in altinda bulunan “Elemental Selenium” linkini textini konsolda yazdirin.
    //locate Elemental selenium text

    @Test
    public void iframeTest(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        System.out.println(driver.findElement(By.xpath("//h3")).getText());

        WebElement frameElement =driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElement);

        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();   //textbox icini siliyoruz
        textBox.sendKeys("Merhaba Dünya");

        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.xpath("//a[@target='_blank']")).getText());



    }


}
