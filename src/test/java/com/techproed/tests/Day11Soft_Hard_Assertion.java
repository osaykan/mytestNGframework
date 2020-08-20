package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Day11Soft_Hard_Assertion {
    //Class name : Soft_Hard_Assertion
    //http://a.testaddressbook.com/sign_in adresine gidin.
    //email textbox,password textbox, ve signin button elementlerini locate edin.
    //Aşağıdaki username ve password girin ve signin buttonuna tıklayın.
    //Username :  testtechproed@gmail.com
    //Password :   Test1234!
    //Daha sonra farklı iddialar(assertions) kullanarak sayfaya doğru giriş yaptığınızı doğrulayın.
    //Daha sonra farklı iddialar(assertions) kullanarak testtechproed@gmail.com beklenen kullanıcı  kimliğinin(userID) doğrulayın
    WebDriver driver;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://a.testaddressbook.com/sign_in");
    }
    @Test                                                 //(priority = 1)
            public void login() {

        WebElement email = driver.findElement(By.id("session_email"));
        email.sendKeys("testtechproed@gmail.com");

        WebElement password = driver.findElement(By.id("session_password"));
        password.sendKeys("Test1234!");

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement signin = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        signin.click();
    }
    @Test(dependsOnMethods = "login")   //(priority =2) olabilirdi veya depends..yazilirsa logine bagladik. Önce login cls.
            public void homapage(){

        WebElement welcome = driver.findElement(By.xpath("//*[.='Welcome to Address Book']"));
        WebElement userId= driver.findElement(By.xpath("//*[.='testtechproed@gmail.com']"));
        String actualId=userId.getText();
        String expectedId="testtechproed@gmail.com";

       // Assert.assertTrue(welcome.isDisplayed());   //Hard assert burasi fail olsaydi alttakiler calismazdi
       // Assert.assertEquals(actualId,expectedId);

        //SOFT ASSERT KULLANARAKTA YAPALIM
        // Create Object
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertTrue(welcome.isDisplayed());
        softAssert.assertEquals(expectedId,actualId);
        softAssert.assertAll();           //assertAll yazilmassa test Fail olmasi gereksede daima pass diye gözükür!!!!!!



    }

    //Hard Assert  : Assert.assertEquals(),True ve False.  Basarisiz ise testin geri kalani calismaz
    //Soft Assert: Basarisiz olan yerde durmaz, geri kalaninida test eder ve ayrintili rapor verir.
    //1) softAssert==> geri kalanini durdurmaz ,önce obje olusturulur.
    // SoftAssert softAssert=new SoftAssert();==> softAssert.assertTrue();==>softAssert.assertAll(); bu
    //üc adimda yazilmali
    //Assertion(Hard Assert) ve Verification(Soft assert) arasindaki benzerlik; TestNG den geliyorlar.
    //Farki; Fail olursa hard da break olur, softta devam eder.

}
