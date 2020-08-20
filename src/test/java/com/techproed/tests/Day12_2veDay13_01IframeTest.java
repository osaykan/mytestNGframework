package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day12_2veDay13_01IframeTest {
    //IFrame baska bir web sayfasina icine yerlestirilmis baska bir web sayfasidir
    //Veya HTML dokumaninin icine yerlestirilmis baska bir HTML documanidir
    //Bir web sayfasina baska bir web sayfasini veya videoyu eklemek icin kullanilir.

    //Iframe yi selenium direk göremez
    //driver.switchTo().frame(index of the iframe);    index


    //Bir class olusturun: IframeTest
    //https://the-internet.herokuapp.com/iframe  adresine gidin.
    //Bir metod olusturun: iframeTest




    @Test
    public void iframeTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //“An IFrame containing….” textini konsolda yazdirin
        System.out.println(driver.findElement(By.xpath("//h3")).getText());
        //Text Box’a “Merhaba Dunya!” yazin.
        // WebElement textBox = driver.findElement(By.xpath("//p")); //FAIL
        //textBox.sendKeys("Merhaba Dunya!");  test fail oldu

        //TEST FAIL OLURSA NE YAPMALIYIZ??
        //1. Locator kontrol edilmeli
        //2. Wait(Bekleme) problemi var mi kontrol edilmeli
        //3. Sayfada Iframe var mi kontrol edilmeli
        //Bu sayfada IFRAME var. Dolayisiyla Iframe switchTo() yapmaliyiz.
        //Bir Iframe switch yapmanin 3 yolu vardir: 1. index ile, 2.id veya name value ile, 3.WebElement ile
       // driver.switchTo().frame(0); // index 0 dan baslar. veya .frame("mce_0_ifr") id value kullanabiliriz
        WebElement frameElement =driver.findElement(By.id("mce_0_ifr"));  //Web element kullanarak. iframe yi locate ediyoruz
        driver.switchTo().frame(frameElement);
        //Artik iframe icindeki elementi bulabiliriz
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();   //textbox icini siliyoruz


        //TextBox’in altinda bulunan “Elemental Selenium” linkini textini konsolda yazdirin.
        //locate Elemental selenium text

       //driver.switchTo().parentFrame(); parente cikarir
        driver.switchTo().defaultContent();//parente cikarir, ilk basa gönderir.
        WebElement seleniumText= driver.findElement(By.linkText("Elemental Selenium"));
        System.out.println(seleniumText.getText());//yazdirmaz cünkü iframenin icindeydik .Parente gecmeliyiz yukariya yaz

        //iframe =========> Direk buraya gelmek icin  defaultContent()   kullanilir.Ilk basa iframenin disina cikarir.
        //   iframe ======>Buraya gelmek istiyorum. parentFrame() kullanilir
        //      iframe  ==> Buradayim. Bir üst iframe cikmak icin
        //        iframe
    }
}