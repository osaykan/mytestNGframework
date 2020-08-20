package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Day15Tekrar extends TestBase {
    //Tests packagenin altina bir class oluşturun : UploadFile
    //Bir metod oluşturun : uploadFileMethod
    //https://the-internet.herokuapp.com/upload adresine gidin
    //Yuklemek istediginiz dosyayi secin.
    //Upload butonuna basin.
    //“File Uploaded!” textinin goruntulendigini dogrulayin.
    @Test
    public void uploadFileMethod(){
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement dataiSelectButton=driver.findElement(By.id("file-upload"));
        String path="C:\\Users\\Mz\\Downloads\\foto.jpg";
        dataiSelectButton.sendKeys(path);

        WebElement uplaodButton=driver.findElement(By.id("file-submit"));
        uplaodButton.click();

        WebElement mesaj=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(mesaj.isDisplayed());

    }


    //Tests packagenin altina bir class oluşturun : FileDownload
    //Iki tane metod oluşturun : isExist() ve downloadTest()
    //önce nerede bulundugumuzu tesbit ediyoruz
    //Hangi dosyayi bulmasini istiyorsak bir yol olusturuyoruz,dosyanin var olup olmadigini bulun

    @Test
    public void isExist(){
      String user=  System.getProperty("user.home");
        System.out.println(user);//C:\Users\Mz
        String filePath=user+"/Downloads/image1.jpg";
        System.out.println(filePath);  //C:\Users\Mz/Downloads/image1.jpg
        boolean isExist=Files.exists(Paths.get(filePath));
        Assert.assertTrue(isExist);

    }

    //downloadTest () metodunun icinde aşağıdaki testi yapın:
    //https://the-internet.herokuapp.com/download adresine gidin.
    //image1.jpg dosyasını indir
    //Ardından dosyanın başarıyla indirilip indirilmediğini doğrulayın.
      @Test
     public void downloadTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/download");
        WebElement selectFile = driver.findElement(By.xpath("//a[@href='download/foto.jpg']"));
        selectFile.click();
          Thread.sleep(5000);
        String filePath="C:\\Users\\Mz\\Downloads\\foto.jpg";
        boolean isExist= Files.exists(Paths.get(filePath));

        Assert.assertTrue(isExist);

      }




    //1.  Bir class olusturun : WaitTest
    //2.  Iki tane metod olusturun :  implicitWait() , explicitWait()
    //Iki metod icin de asagidaki adimlari test edin.
    //3.  https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4.  Remove butonuna basin.
    //5.  “It’s gone!” mesajinin goruntulendigini dogrulayin.
    @Test
    public void explicitWait(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButon = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        removeButon.click();
        WebDriverWait wait= new WebDriverWait(driver,20);
        WebElement mesaj=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
       // Assert.assertEquals(mesaj.getText(),"It's gone!");
        Assert.assertTrue(mesaj.isDisplayed());
    }
}
