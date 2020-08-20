package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.pages.FHCRezervasyonPages;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Day18_04FHCRezervasyonTest extends TestBase {

    @Test
    public void fhcRezervasyonTest() throws InterruptedException {
        driver.get("http://www.fhctrip.com/admin/RoomReservationAdmin/Create");
        FHCLoginPage fhcLoginPage=new FHCLoginPage(driver);
        FHCRezervasyonPages fhcRezervasyonPages=new FHCRezervasyonPages(driver);
        fhcLoginPage.login2();

        Select idUserSelect=new Select(fhcRezervasyonPages.idUser);
        idUserSelect.selectByIndex(1);

        Select idHotelRoomSelect= new Select(fhcRezervasyonPages.idHotelRoom);
       idHotelRoomSelect.selectByIndex(99);

        fhcRezervasyonPages.price.sendKeys("250");
        fhcRezervasyonPages.dateStart.sendKeys("08/21/2020");
        fhcRezervasyonPages.dateEnd.sendKeys("08/28/2020");
        fhcRezervasyonPages.adultAmount.sendKeys("2");
        fhcRezervasyonPages.childrenAmount.sendKeys("2");
        fhcRezervasyonPages.surname.sendKeys("Osman");
        Thread.sleep(5000);
        fhcRezervasyonPages.phone.sendKeys("4915700000");
        fhcRezervasyonPages.email.sendKeys("o@akn.com");
        fhcRezervasyonPages.notes.sendKeys("süt banyosu");
        fhcRezervasyonPages.isApproved.click();
        fhcRezervasyonPages.isPaid.click();
        fhcRezervasyonPages.saveButton.click();

       WebDriverWait wait= new WebDriverWait(driver,10);
       WebElement kayitmesaji= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bootbox-body']")));
       Assert.assertTrue(kayitmesaji.isDisplayed());
       // driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);


        fhcRezervasyonPages.okButton.click();

    }


}
