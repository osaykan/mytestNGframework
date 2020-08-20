package com.techproed.tests;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day28_02DataProviderDemo {
    //@DataProvider bir TestNG annotation'idir. Sadece TestNG ile kullanilir.
    // Cucumberda Seneriooutline    Example gibi kullanitir
    //Veri saglamakl icin kullanilir.DDT(Data Driven Test) yapilir.

   // @Test(dataProvider = "getData") //alttaki methodu okumasi icin yazdik  1.sefer method ismiyle
   @Test(dataProvider = "log in data")   //veya altta methoda isim verip burada o isimle cagirdik
    public void loginTest(String user, String pass){

        Driver.getDriver().get(ConfigurationReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage = new FHCLoginPage(Driver.getDriver());
        fhcLoginPage.username.sendKeys(user);     //Buraya birden fazla deger göndermek istiyoruz.
        fhcLoginPage.password.sendKeys(pass); //Asagida method olusturuyoruz.
        fhcLoginPage.loginButton.click();
        Assert.assertTrue(fhcLoginPage.errormesaj.getText().contains("Try again please"));
    }

      //@DataProvider    1.seferde
        @DataProvider(name = "log in data")
    public Object[][] getData(){        //ikili array yaptik iki ayri yere user ve passworda veri gönderecegiz
        // {{user1,pass1},{user2,pass2},{user3,pass3}}
        Object[][] data = new Object[3][2];
        //1.datalar
        data[0][0]="user1";
        data[0][1]="pass1";
        //2.siradaki datalar
        data[1][0]="user2";
        data[1][1]="pass2";
        //3.siradaki datalar
        data[2][0]="user3";
        data[2][1]="pass3";


        return data;
    }


}


