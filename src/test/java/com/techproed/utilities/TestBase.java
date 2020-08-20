package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    //TestBase testlerden önce ve sonra tekrar tekrar kullandigimiz kodlari icermektedir.
    //Icerisindeki methodlari kullanabilmemiz icin extend yapiyoruz.Bu sayede test classimizda sadece test case ler bulunmaktadir.
    //Utilities package de TestBase i olusturuyoruz.
    // *setUp method
    // *reports (Raporlar)
    // * tearDown method
    //TestBase classi abstract yapabiliriz(Olmasada olabilir), extend yaparak kullanabiliriz.Ve bu clsass da obje create edemeyiz
    protected Actions actions;
   protected WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         actions=new Actions(driver);


    }
    @AfterMethod
    public void tearDown(){
     //   driver.close();
    }
}
