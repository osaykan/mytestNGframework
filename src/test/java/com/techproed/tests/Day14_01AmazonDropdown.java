package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Day14_01AmazonDropdown extends TestBase {
    //Tests packagenin altinda bir class olusturun: AmazonDropdown
    //2. https://www.amazon.com/ adresine gidin.
    //3. Dropdown elementini bulun.
    //4. İlk seçilen seçeneği(firstSelectedOption) konsolda yazdırın ve ilk secenegin "All
    //Departments" ile esit oldugunu dogrulayin.
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
    public void amazonDropdownTest() {
        driver.get("https://www.amazon.com/");
        //3. Dropdown elementini bulun.
        WebElement dropDownElement=driver.findElement(By.id("searchDropdownBox"));
        //4. İlk seçilen seçeneği(firstSelectedOption) konsolda yazdırın ve ilk secenegin "Alle
        //Departments(Kategorien)" ile esit oldugunu dogrulayin.
        Select select=new Select(dropDownElement);
        String firstOption = select.getFirstSelectedOption().getText();
        Assert .assertEquals(firstOption,"Alle Kategorien");
        //5. 6.seçeneği(option) index kullanarak secin ve 6.seçeneğin "Books""Elektronik) oldugunu
        select.selectByIndex(5);
        String option6=select.getFirstSelectedOption().getText();
                Assert.assertEquals(option6,"Elektronik");
        //6. Butun dropdown seçeneklerini konsolda yazdırın
        List<WebElement> allOptions=select.getOptions();
        for (WebElement option: allOptions ) {
            System.out.println(option.getText());

        }
        //7. Dropdowndaki eleman sayisini konsolda yazdırın
        int optionsSayisi=allOptions.size();
        System.out.println("Drop Downdaki eleman sayisi :"+optionsSayisi);

        //8. "Electronics" ın dropdownda olup olmadığını kontrol edin. "Electronics" dropdownda
        ////bulunuyorsa konsolda True yazdırın. Aksi takdirde False yazdırın.

        boolean flag=false;
        for(WebElement option:allOptions){
            if(option.getText().equals("Elektronik")){
                flag=true;
                break;
            }


        }
        System.out.println(flag);

    }
}
