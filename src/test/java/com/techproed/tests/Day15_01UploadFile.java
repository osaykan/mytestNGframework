package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day15_01UploadFile extends TestBase {
    //Tests packagenin altina bir class oluşturun : UploadFile
    //Bir metod oluşturun : uploadFileMethod
    //https://the-internet.herokuapp.com/upload adresine gidin
    //Yuklemek istediginiz dosyayi secin.
    //Upload butonuna basin.
    //“File Uploaded!” textinin goruntulendigini dogrulayin.
    @Test
    public  void uploadFileMethod(){
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFileButton= driver.findElement(By.id("file-upload"));//type  ve file olmali
        String filePath="C:\\Users\\Mz\\Downloads\\foto.jpg";
        //SendKeys() kullanabilmek icin chooseFile elementinin tag=input ve type="file" olmali
        chooseFileButton.sendKeys(filePath);

        //Upload butonuna basin.
        WebElement uploadButton=driver.findElement(By.id("file-submit"));
        uploadButton.click();
        //“File Uploaded!” textinin goruntulendigini dogrulayin.
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(),"File Uploaded!");

    }
}
