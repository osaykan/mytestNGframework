package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day16_02CreateHotel extends TestBase {
    //Tests packagenin altina class olusturun: CreateHotel
    //Bir method olusturun: createHotel
    //http://www.fhctrip.com/admin/HotelAdmin/Create adresine gidin.
    //Username textbox ve password textboxlarini locate edin ve asagidaki verileri girin.
    //Username : manager2
    //Password : Man1ager2!
    //Login butonuna basin.
    //Acilan sayfadaki butun textboxlara istediginiz verileri girin (en sondaki dropdowna dikkat edin).
    //Save butonuna basin.
    //“Hotel was inserted successfully” textinin goruntulendigini dogrulayin.
    //OK butonuna tiklayin.


    @Test
    public void createHotel() throws InterruptedException {
        driver.get("http://fhctrip-qa.com/admin/HotelAdmin/Create");

        WebElement userNameBox=driver.findElement(By.id("UserName"));
        userNameBox.sendKeys("manager2");

        WebElement passwordBox=driver.findElement(By.id("Password"));
        passwordBox.sendKeys("Man1ager2!");

        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement codeBox=driver.findElement(By.id("Code"));
        codeBox.sendKeys("Butik Otel");

        WebElement nameBox=driver.findElement(By.id("Name"));
        nameBox.sendKeys("Erholung");

        WebElement adresBox=driver.findElement(By.id("Address"));
        adresBox.sendKeys("Kanarya straße 17, Berlin");
        Thread.sleep(1000);
        driver.findElement(By.id("Phone")).sendKeys("12345678987");

        WebElement emailBox=driver.findElement(By.id("Email"));
        emailBox.sendKeys("osmanaykan34@gmail.com");

        WebElement idGroup=driver.findElement(By.id("IDGroup"));

        Select select = new Select(idGroup);
        select.selectByIndex(1);

        WebElement saveButtun=driver.findElement(By.id("btnSubmit"));
        saveButtun.click();

        //“Hotel was inserted successfully” textinin goruntulendigini dogrulayin.  Beklenmesi gerekiyor mesaj gözükünceye kadar
        WebDriverWait wait=new WebDriverWait(driver,10);
        boolean isTrue=wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='bootbox-body']"),"Hotel was inserted successfully"));
        Assert.assertTrue(isTrue);


        WebElement okButton=driver.findElement(By.xpath("//button[@data-bb-handler='ok']"));
        okButton.click();




    }
}
