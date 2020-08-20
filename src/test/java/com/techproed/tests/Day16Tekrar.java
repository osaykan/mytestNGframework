package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day16Tekrar extends TestBase {
    //	Bir class olusturun : EnableTest
    //2.	Bir metod olusturun :  isEnabled()
    //3.	https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4.	Enable butonuna basin.
    //5.	Textbox’in etkin olup olmadigini(enabled) dogrulayin.
    //6.	“It’s enabled!” mesajinin goruntulendigini dogrulayin.

    @Test
    public void isEnable(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement onclickButton= driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        onclickButton.click();

        WebDriverWait wait= new WebDriverWait(driver,20);
        WebElement mesaj=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertEquals(mesaj.getText(),"It's enabled!");
    }





    //Tests packagenin altina class olusturun: CreateHotel
    //Bir method olusturun: createHotel
    //http://www.fhctrip.com/admin/HotelAdmin/Create adresine gidin.
    //Username textbox ve password textboxlarini locate edin ve asagidaki verileri girin.
    //Username : manager2
    //Password : Man1ager2!
    //Login butonuna basin.
    //Acilan sayfadaki butun textboxlara istediginiz verileri girin (en sondaki dropdowna dikkat edin).
    //Save butonuna basin.
    //“Hotel was inserted successfully” textinin goruntulendigini dogrulayin.
    //OK butonuna tiklayin.


    //Tests packagenin altina class olusturun: HotelRoomCreation
    //Bir method olusturun:  RoomCreateTest()
    //http://www.fhctrip.com/admin/HotelRoomAdmin adresine gidin.
    //Username textbox ve password textboxlarini locate edin ve asagidaki verileri girin.
    //Username : manager2
    //Password : Man1ager2!
    //Login butonuna basin.
    //Add Hotel room butonuna tiklayin
    //Acilan sayfadaki butun textboxlara istediginiz verileri girin
    //Save butonuna basin.
    //“HotelRoom was inserted successfully” textinin goruntulendigini dogrulayin.
    //OK butonuna tiklayin.
    //Hotel rooms linkine tiklayin.
    //"LIST OF HOTELROOMS" textinin goruntulendigini(isDisplayed) dogrulayin.




}
