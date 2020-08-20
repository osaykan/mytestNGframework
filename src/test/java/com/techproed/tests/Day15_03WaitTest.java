package com.techproed.tests;

import com.techproed.utilities.TestBase;
import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day15_03WaitTest extends TestBase {
    //1.  Bir class olusturun : WaitTest
    //2.  Iki tane metod olusturun :  implicitWait() , explicitWait()
    //Iki metod icin de asagidaki adimlari test edin.
    //3.  https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4.  Remove butonuna basin.
    //5.  “It’s gone!” mesajinin goruntulendigini dogrulayin.
    @Test
    public void implicitWait(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement removeButton=driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        removeButton.click();

       // driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);TestBase clasörde var zaten
        WebElement goneMessage=driver.findElement(By.id("message"));//It's gone!  mesaji gelinceye kadar bekle.Mesaji locate ettik

        Assert.assertEquals(goneMessage.getText(),"It's gone!");


    }
    @Test
    public void explicitWait(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement removeButton=driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        removeButton.click();

       WebElement goneMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));



        Assert.assertEquals(driver.findElement(By.id("message")).getText(),"It's gone!");
                         //( goneMessage.getText(),"It's gone!");    yazilabilirdi                                                              )

        /*

SELENIUM WAITS - SENKRONIZASYON
Senkronizasyon, otomasyon tester'lar için çok önemlidir.
İyi bir test yürütmesi için bu konsepte ihtiyacımız var.
TEST CASE AŞAĞIDAKİ SEBEPLERDEN DOLAYI FAIL OLABİLİR:
1. Selenyum otomasyon komut dosyası(script) sorunu - locator yanlış olabilir.
Locator doğruysa:
2. Yürütme hızı - çok hızlı olabilir.
3. Web uygulaması hızı - çok yavaş olabilir.
4. İnternet çok yavaş olabilir.
5. Web sayfası yavaş yükleniyor olabilir. Çok fazla elementi olabilir(gorseller, iframe'ler)
Bu gibi durumlarda Senkronize etmek için beklemeler kullanmamız gerekir.
======================================================================
Iki tür bekleme(wait) vardır:
1.Implicit Wait:
-Sadece bir syntax vardir => driver.manage().timeouts().implicitlywait(10,TimeUnit.SECONDS);
-Global bekleme olarak bilinir
-driver objesi kullanildiginda uygulanir.
-Dinamiktir, driver elementi bulur bulmaz yürütmeye devam edecektir.
Yukarıdaki örnekte, sürücü 10 saniye kadar bekleyecektir. 3 saniye içinde bulunursa, 7 saniye daha beklemez.
2.Explicit Wait:
-Bir ExpectedConditions icin explicit wait kullanıyoruz
-Kullanmak için WebDriverWait objesi create etmeliyiz.

     WebDriverWait wait = new WebDriverWait (driver, 10);
-Şimdi beklenen kosula(expected condition) gecmek icin wait objesini kullanabilirim.
WebElement element = wait.until (ExpectedConditions.visibilityOfElementLocated (By.id ( "id value")));
=====================================================================
Soru: Selenium'da Senkronizasyon sorununu nasıl çözersiniz?
Locator'i düzelttiğini söyleme-> Bu Senkronizasyon ile ilgili değil
Cevap: Framework'umde TestBase classinda implicitly wait create ettim ve gerektiginde driver icin calisiyor.
       Implicitly wait  işe yaramadığı bazı durumlar olabilir. Bu durumda, Thread.sleep (5000); Ancak, bu iyi bir fikir değildir, çünkü Thread.sleep SABİT BEKLİYOR(HARD WAIT).
       Bu nedenle, explicit wait kullanıyorum. Beklenen koşulları(expected conditions) kullanabilirim. Belirli koşulları ile uğraşırken bu çok yardımcı olur. Explicit wait de dinamiktir.
=====================================================================
Soru: Hangisini tercih ediyorsun?
Cevap: Duruma gore değişir. Implicitly wait kullanımı daha kolaydır. Bir kez oluşturun, her zaman kullanın.
       Ancak Explicit wait'in daha iyi çalıştığı bazı durumlar vardır. Boyle durumlarda explicit wait kullanmak gerekir. Explicit wait bana daha fazla koşul ve seçenek sunuyor.
=====================================================================
         */

    }
}
