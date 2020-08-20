package com.techproed.smoketest;

import com.techproed.pages.FaceLoginPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day18_01FaceLoginTest extends TestBase {
    //Yeni bir class oluşturun: FaceLoginTest
    //Bir test metodu oluşturun: faceLoginTest ()
    //Kullanıcı geçersiz kimlik bilgileri girdiğinde,
    // kullanıcı “The email or phone number you’ve entered doesn’t match any account.” mesajini görmelidir.
    //https://www.facebook.com/
    //Username: fakeusername
    //Password: fakepassword


    @Test
    public void faceLoginTest() {
        driver.get("https://www.facebook.com/");

        FaceLoginPage faceLoginPage=new FaceLoginPage(driver);

        faceLoginPage.email.sendKeys("fakeusername");
        faceLoginPage.password.sendKeys("fakepassword");
        faceLoginPage.loginButton.click();

       // Assert.assertTrue(faceLoginPage.error_mesaj.isDisplayed());   wait problemi yoksa calisir

        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement errorMesaj=wait.until((ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//div[@role='alert']")))) ;
        Assert.assertTrue(errorMesaj.isDisplayed());

    }

}
