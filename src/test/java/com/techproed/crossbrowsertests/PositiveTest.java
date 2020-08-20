package com.techproed.crossbrowsertests;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseCross;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
public class PositiveTest extends TestBaseCross {
    //CROSS BROWSER TEST
    //xml file -> TestBaseCross -> DriverCross
    //xml file:  Selenium xml file'sa parameter olup olmadigini kontrol eder.
    //           Eger bir parameter varsa onu olur(parameter="browser" value="firefox")
    //TestBaseCross: Eger xml'de parameter="browser" varsa TestBaseCross patameter olarak browser value kullanir. Baglantiyi @Parameters("browser") annotation'i ile saglar.
    //DriverCross: Driver'i kontrol eder ve arkasindan create eder.
    //browser = browser == null ? ConfigReader.getProperty("browser") : browser;
    //    Eger browser null ise onu configuration.properties'den al.
    //    Eger browser null degil ise browser'i xml file'den al.
    @Test
    public void positiveLoginTest() throws InterruptedException {
        driver.get("http://www.fhctrip.com/Account/Logon");
        WebElement userNameBox = driver.findElement(By.id("UserName"));
        WebElement passwordBox = driver.findElement(By.id("Password"));
        WebElement loginButton = driver.findElement(By.id("btnSubmit"));
        userNameBox.sendKeys("manager2");
        passwordBox.sendKeys("Man1ager2!");
        loginButton.click();
    }
}
