package com.techproed.tests;

import com.techproed.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Day11Tekrar {
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

    @Test
    public void softHardAssertion(){


        WebElement emaiBox = driver.findElement(By.id("session_email"));
        emaiBox.sendKeys("testtechproed@gmail.com");

        WebElement passwordBox=driver.findElement(By.id("session_password"));
        passwordBox.sendKeys("Test1234!");

     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement signInButton=driver.findElement(By.name("commit"));
        signInButton.click();


    }
    @Test(dependsOnMethods ="softHardAssertion" )
    public void dogrulama(){


        WebElement welcome=driver.findElement(By.xpath("//*[.='Welcome to Address Book']"));
        WebElement userId= driver.findElement(By.xpath("//span[@class='navbar-text']"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(userId.getText(),"testtechproed@gmail.com");
       softAssert.assertTrue(welcome.isDisplayed());
        softAssert.assertAll();

    }


}
