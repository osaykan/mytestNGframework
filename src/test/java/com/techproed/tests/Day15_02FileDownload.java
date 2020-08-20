package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day15_02FileDownload extends TestBase {
    //Tests packagenin altina bir class oluşturun : FileDownload
    //Iki tane metod oluşturun : isExist() ve downloadTest()


    @Test
    public void isExist(){
        //önce nerede bulundugumuzu tesbit ediyoruz
        String mevcutKlasör=System.getProperty("user.dir");
        System.out.println("Mevcut Klasör : "+mevcutKlasör);// C:\Users\Mz\IdeaProjects\mytestNGframework

        String userKlasör= System.getProperty("user.home");
        System.out.println("User Klasör : "+userKlasör);  // C:\Users\Mz

        //Hangi dosyayi bulmasini istiyorsak bir yol olusturuyoruz
        String filePath = userKlasör +  "/Downloads/foto.jpg";
        System.out.println(filePath);
        //String filePath="C:\\Users\\Mz\\Downloads\\foto.jpg"   bu sekildede olurdu
       boolean isFileExist= Files.exists(Paths.get(filePath)); //true veya false //language level 7  import edince kirmizilik gider
        Assert.assertTrue(isFileExist);//eger dosya varsa true ve Pass,yoksa false ve Fail

    }
    @Test
    public void downloadTest() throws InterruptedException {
        //downloadTest () metodunun icinde aşağıdaki testi yapın:
        //https://the-internet.herokuapp.com/download adresine gidin.
        //image1.jpg dosyasını indir
        //Ardından dosyanın başarıyla indirilip indirilmediğini doğrulayın.
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement image1=driver.findElement(By.linkText("image1.jpg"));
        image1.click();

        Thread.sleep(5000);  //Dosyanin yüklenmesi icin zamana ihtiyac olabilir
        //Ardından dosyanın başarıyla indirilip indirilmediğini doğrulayın.
       String userKlasör= System.getProperty("user.home");

       String filePath = userKlasör + "/Downloads/image1.jpg";
    //Dosya vaarmi yokmu kontrol ediyoruz
       boolean isDownload=Files.exists(Paths.get(filePath));
       Assert.assertTrue(isDownload);  //dosya yüklendi ise Pass, degilse Fail

    }

}
