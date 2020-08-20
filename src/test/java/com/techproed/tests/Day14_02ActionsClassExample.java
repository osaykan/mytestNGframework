package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day14_02ActionsClassExample extends TestBase {
    //Create  class: ActionsClassExample
    //Create  test method : contextClickMethod() ve aşağıdaki senaryoyu test edin:
    //https://the-internet.herokuapp.com/context_menu web sitesine gidin.
    //Dikdörtgen kutu icinde sağa tıklayın.
    //Alert mesajinin “You selected a context menu” oldugunu dogrulayin.
    //Alert’te OK ye basin
    @Test(groups="group test1")
    public void contextClickMethod(){
        //https://the-internet.herokuapp.com/context_menu web sitesine gidin.
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //Dikdörtgen kutu icinde sağa tıklayın.
        WebElement dikdortgen = driver.findElement(By.id("hot-spot"));
        //create Actions class
       // Actions actions=new Actions(driver);====>TestBase ye alacagiz
        actions.contextClick(dikdortgen).perform();  //.contextClick(dikdortgen)===> sag tikla demek  .perform()==>yap demek
        //Alert mesajinin “You selected a context menu” oldugunu dogrulayin.
       String actualText= driver.switchTo().alert().getText();
       String expectedText="You selected a context menu";
        Assert.assertEquals(actualText,expectedText);

        //Alert’te OK ye basin
        driver.switchTo().alert().accept();
    }
    //Create  test method : hoverOver() ve aşağıdaki senaryoyu test edin:
    //https://www.amazon.com/  web sitesine gidin.
    //“Your Account” linkine tıklayın.
    //Sayfa basliginin(page title) “Your Account) icerdigini(contains) dogrulayin.
@Test(groups="group test1")
    public void hoverOver(){      //hoverOver ==>bir elementin üzerine gelmek demektir
        driver.get("https://www.amazon.com/");
    //“Your Account” linkine tıklayın.==>önce locate etmeliyiz
    WebElement helloSignIn=driver.findElement(By.xpath("//span[text()='Hallo, Anmelden']"));
    actions.moveToElement(helloSignIn).perform();
    WebElement yourAccont = driver.findElement(By.linkText("Mein Konto"));
    yourAccont.click();

    //Sayfa basliginin(page title) “Your Account) icerdigini(contains) dogrulayin.

    }
    @Test
    public void keysUpDown(){
        //https://www.google.com/ adresine gidin.
        //Google text box’a IPHONE (capital) yazdirin
        //( input(giris) => iphone , output => IPHONE)
        //Text box’ta cift tiklayin(double click).
        driver.get("https://www.google.com/");
        WebElement searchBox=driver.findElement(By.name("q"));
        //Google text box’a IPHONE (capital) yazdirin
        //( input(giris) => iphone , output => IPHONE)
       // searchBox.sendKeys(Keys.SHIFT+"iphone");             //1.Yol
       // actions.keyDown(searchBox,Keys.SHIFT).sendKeys("iphone").keyUp(searchBox,Keys.SHIFT).perform();//2.yol
        actions.                                             //3.Yol
                moveToElement(searchBox).
                click().
                keyDown(Keys.SHIFT).
                sendKeys("iphone").
                perform();
        //Text box’ta cift tiklayin(double click).
        actions.doubleClick(searchBox).perform();


        //   searchBox.sendKeys("iphone"); Seklinde yzarsak KUCUK harlerle gonderir.
// Bizde istenen kucuk harflerle yazip searchBox a BUYUK yazilmasi. (BUYUK yazmanin 2 yolu var)
 //       searchBox.sendKeys(Keys.SHIFT+"iphone"); //1. YOL
// actions.moveToElement(searchBox).keyDown(Keys.SHIFT).sendKeys("iphone").perform(); // 2. YOL
// *1 Eger bir yerde keyDown yaparsak hep oyle kalir(SHIFT Basili kalir)
//    onun icin tekrar yazacaksak keyUp yapmaliyiz.
// ACTION kullandigimiz zaman en sonunda mutlaka PERFORM kullanmak zorundayiz.
//  actions.keyDown(searchBox,Keys.SHIFT).sendKeys("iphone").keyUp(searchBox,Keys.SHIFT).perform();

    }
    @Test
    public void scrollUpDown() throws InterruptedException {      //sayfada asagi veya yukari nasil gidilir
        driver.get("https://www.amazon.com/");
        //Sayfayi asagi dogru kaydirma
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //Bir sayfada birden fazla page_down ve page_up kullanabiliriz
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        actions.sendKeys(Keys.ARROW_DOWN).perform();  //arrow_down da sayfa asagi inmeyi saglar ama daha az

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        actions.sendKeys(Keys.PAGE_UP).perform();  //sayfayi yukari kaydirir.

       Thread.sleep(5000);
        actions.sendKeys(Keys.ARROW_UP).perform();//yukari ama daha az kaydirir.


    }
}
