package com.techproed.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.techproed.pages.GlbHomePage;
import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReports1 {

    //utulities e git==>new java class ==> TestBaseFinal
    //       " " " ===>   """""""     ====>ReusableMethods
    //ExtentReports ===> raporlamaya baslamak icin ihtiyacimiz var.Raporu kapatmak   (flush())  icin kullaniyoruz
    //ExtentHtmlReporter ==> Raporlari yapilandirmaya(configuration) yardimci olur ve Html raporlari creat eder
    //ExtentTest==> Aciklama(logs) eklemek icin , gtest adimlarini belirlemek icin kullanilir.Test classinin icine yaz

    public ExtentReports extentReports;
    public ExtentHtmlReporter extentHtmlReporter;
    public ExtentTest extentTest;

    @BeforeTest
    public void setup(){
        //reporter'i baslatalim ve konumunu ayarlayalim.
        //                                      klasör: reports , dosya= adi: extentreport.html
        extentHtmlReporter=new ExtentHtmlReporter("./reports/extentreport.html");
        //extentHtmlReporter ile bazi yapilandirmalar yapalim
        extentHtmlReporter.config().setReportName("GLB trader Report");
        extentHtmlReporter.config().setTheme(Theme.STANDARD);
        extentHtmlReporter.config().setDocumentTitle("GLB sign up report");
        extentHtmlReporter.config().setEncoding("UTF-8");

        //extentReports'u creat edelim
        extentReports=new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);

        //daha fazla aciklama ekleyebiliriz
        extentReports.setSystemInfo("Automation engineer","Osman");
        extentReports.setSystemInfo("Browser","chrome");

    }
    @AfterTest
    public void endReport(){
        extentReports.flush();   //Raporu kapatiyor
    }

    @Test
    public void glbSignUp() throws InterruptedException {


        GlbSignUpPage glbSignUpPage = new GlbSignUpPage();
        GlbHomePage glbHomePage=new GlbHomePage();    //21 gün bu objeyi olusturduk. Iki farkli classtan cagri yapiyoruz


        extentTest = extentReports.createTest("GLB Sign Up Test");
        extentTest.info("Url'e git");

        Driver.getDriver().get(ConfigurationReader.getProperty("glb_url"));
        extentTest.info("join now linkine tikla");
        glbHomePage.joinNowLink.click();
        extentTest.info("email gonder");
        glbSignUpPage.email.sendKeys(ConfigurationReader.getProperty("test_email"));
        extentTest.info("username gonder");
        glbSignUpPage.name.sendKeys(ConfigurationReader.getProperty("test_username"));
        extentTest.info("telefon numarasi gönder");
        glbSignUpPage.phone.sendKeys(ConfigurationReader.getProperty("test_phone"));
        extentTest.info("pasword'u  yaz");
        glbSignUpPage.password.sendKeys(ConfigurationReader.getProperty("test_password"));
        extentTest.info("pasword'u tekrar yaz");
        glbSignUpPage.repassword.sendKeys(ConfigurationReader.getProperty("test_password"));
        extentTest.info("sign up'a tikla");
        glbSignUpPage.signUpButton.click();
        Thread.sleep(3000);
        Assert.assertFalse(glbSignUpPage.successMesaj.getText().equals("Success!"));
        //Test fail olacak cunkü actual Success! ! fakat expected Success!
        extentTest.pass("PASSED: Test basariyla tamamlandi");

        Driver.closeDriver();
        extentTest.pass("Driver basariyla kapatildi");

    }

}
