package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Day14Tekrar extends TestBase {
    //Tests packagenin altinda bir class olusturun: AmazonDropdown
    //2. https://www.amazon.com/ adresine gidin.
    //3. Dropdown elementini bulun.
    //4. İlk seçilen seçeneği(firstSelectedOption) konsolda yazdırın ve ilk secenegin "All
    //Departments" ile esit oldugunu dogrulayin.(Alle Kategorien)
    //5. 6.seçeneği(option) index kullanarak secin ve 6.seçeneğin "Books" oldugunu
    //dogrulayin.(Seçtikten sonra getFirstSelectedOption() metodunu kullanmanız gerekir)
    //6. Butun dropdown seçeneklerini konsolda yazdırın
    ////7. Dropdowndaki eleman sayisini konsolda yazdırın
    ////8. "Electronics" ın dropdownda olup olmadığını kontrol edin. "Electronics" dropdownda
    ////bulunuyorsa konsolda True yazdırın. Aksi takdirde False yazdırın.
    ////NOT: TestBase classini kullanalim. Dogrulama yaparken Assertion kullanalim.
    ////Test case'de verilen secenekler sizde farkli olabilir. Sizde gorunen seceneklere gore
    ////kodunuzu yazabilirsiniz.
    @Test
    public void amazonDropdown(){
        driver.get("https://www.amazon.com/");

        WebElement dropDownbutton=driver.findElement(By.id("searchDropdownBox"));
       // dropDownbutton.click();
        Select select=new Select(dropDownbutton);
       String option1= select.getFirstSelectedOption().getText();
        System.out.println(option1);
        Assert.assertEquals(option1,"Alle Kategorien");

        //5. 6.seçeneği(option) index kullanarak secin ve 6.seçeneğin "Books"(Elektronik) oldugunu
        //dogrulayin.(Seçtikten sonra getFirstSelectedOption() metodunu kullanmanız gerekir)
        //6. Butun dropdown seçeneklerini konsolda yazdırın
        ////7. Dropdowndaki eleman sayisini konsolda yazdırın
        ////8. "Electronics" ın dropdownda olup olmadığını kontrol edin. "Electronics" dropdownda
        ////bulunuyorsa konsolda True yazdırın. Aksi takdirde False yazdırın.
        ////NOT: TestBase classini kullanalim. Dogrulama yaparken Assertion kullanalim.
        ////Test case'de verilen secenekler sizde farkli olabilir. Sizde gorunen seceneklere gore
        ////kodunuzu yazabilirsiniz.
        select.selectByIndex(5);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Elektronik");

        List<WebElement> alloptions=select.getOptions();
        for(WebElement optionsalle:alloptions){
            System.out.println(optionsalle.getText());
        }
        System.out.println("Options sayisi : "+alloptions.size());
        if(alloptions.contains("Elektronik")){
            System.out.println("True");
        }else {
            System.out.println("False");
        }

        //Alternatif
        boolean flag=false;
        for(WebElement option:alloptions){
            if(option.getText().equals("Elektronik")){
                flag=true;
                break;
            }


        }
        System.out.println(flag);

    }
    //Create  class: ActionsClassExample
    //Create  test method : contextClickMethod() ve aşağıdaki senaryoyu test edin:
    //https://the-internet.herokuapp.com/context_menu web sitesine gidin.
    //Dikdörtgen kutu icinde sağa tıklayın.
    //Alert mesajinin “You selected a context menu” oldugunu dogrulayin.
    //Alert’te OK ye basin
    @Test
    public void contextClickMethod(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement dikdörtgen= driver.findElement(By.id("hot-spot"));
        actions.contextClick(dikdörtgen).perform();
        Assert.assertEquals(driver.switchTo().alert().getText(),"You selected a context menu");
        driver.switchTo().alert().accept();
    }

    //Create  test method : hoverOver() ve aşağıdaki senaryoyu test edin:
    //https://www.amazon.com/  web sitesine gidin.
    //“Your Account” linkine tıklayın.
    //Sayfa basliginin(page title) “Your Account) icerdigini(contains) dogrulayin.
    @Test
    public void hoverOver(){
        driver.get("https://www.amazon.com/");
        WebElement accountbutton=driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
        actions.moveToElement(accountbutton).perform();
        driver.findElement(By.linkText("Mein Konto")).click();
        Assert.assertEquals(driver.getTitle(),"Mein Konto");


    }

    //https://www.google.com/ adresine gidin.
    //Google text box’a IPHONE (capital) yazdirin
    //( input(giris) => iphone , output => IPHONE)
    //Text box’ta cift tiklayin(double click).
    @Test
    public void google(){
        driver.get("https://www.google.com/");
        WebElement textBox= driver.findElement(By.cssSelector("input[name='q']"));

      //  textBox.sendKeys(Keys.SHIFT+"iphone");//====>1.yol
        actions.keyDown(textBox,Keys.SHIFT).sendKeys("iphone").keyUp(textBox,Keys.SHIFT).perform();

        actions.doubleClick(textBox).perform();
    }

    //https://www.amazon.com/ sayfasina gidin
    //Sayfayi asagi dogru kaydirma
    //Sayfayi asagi dogru biraz dahe kaydirma
    //sayfayi yukari kaydirir.
    //sayfayi yukari biraz daha kaydirir.

    @Test
    public void amazon(){
        driver.get("https://www.amazon.com/");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions.sendKeys(Keys.ARROW_UP).perform();
        actions.sendKeys(Keys.PAGE_UP).perform();
    }
}
