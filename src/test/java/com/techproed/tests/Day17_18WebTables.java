package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Day17_18WebTables extends TestBase {
    /*
    table==>Tablo >     thead==>Baslik>      tr==>satir(row)>      th==>baslik verileri

    tbody==>tablo gövdesi>      tr==>row-satir>         td==>tablo verileri(table date)-hücre(cell)

     */
    //Bir class oluşturun : WebTables
    //login() metodun oluşturun ve oturum açın.
    //http://www.fhctrip.com/admin/HotelRoomAdmin
    //Username : manager2
    //Password : Man1ager2!

    //table() metodu oluşturun
    //Tüm table body’sinin boyutunu(size) bulun.
    //Table’daki başlıkları(headers) konsolda yazdırın.

    //printRows() metodu oluşturun
    //table body’sinde bulunan toplam satir(row) sayısını bulun.
    //Table body’sinde bulunan satirlari(rows)  konsolda yazdırın.
    //4.satirdaki(row) elementleri konsolda yazdırın.

    //printCells() metodu oluşturun
    //table body’sinde bulunan toplam hücre(cell) sayısını bulun.
    //Table body’sinde bulunan hücreleri(cells)  konsolda yazdırın.

    //printColumns() metodu oluşturun
    //table body’sinde bulunan toplam sutun(column) sayısını bulun.
    //Table body’sinde bulunan sutunlari(column)   konsolda yazdırın.
    //5.column daki elementleri  konsolda yazdırın.

    public void login(){
        driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");;
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");;
        driver.findElement(By.xpath("//button[@type='submit']")).click();



    }
    //table() metodu oluşturun
    //Tüm table body’sinin boyutunu(size) bulun.
    //Table’daki başlıkları(headers) konsolda yazdırın.
    @Test
    public void table() throws InterruptedException {
        login();  //yukardaki methodu cagirdik
        //tbody deki datalari konsola yazdiriyoruz
        Thread.sleep(3000);
        WebElement tbody=driver.findElement(By.xpath("//tbody"));
        System.out.println(tbody.getText());

        //size    Kactane hücre var(cell)
        List<WebElement> table=driver.findElements(By.xpath("//tbody//td"));
        System.out.println("Table Body Size : "+table.size());



        //headers ler ==>basliklar
        System.out.println("      ===BASLIKLAR====");
        List<WebElement> allHeaders=driver.findElements(By.tagName("th"));//Basliklarin tag'i th. TagName kullaniriz
        for(WebElement header:allHeaders){
            System.out.println(header.getText());
        }

    }
    //printRows() metodu oluşturun
    //table body’sinde bulunan toplam satir(row) sayısını bulun.
    //Table body’sinde bulunan satirlari(rows)  konsolda yazdırın.
    //4.satirdaki(row) elementleri konsolda yazdırın.
    @Test
    public void printRows(){
        login();
        System.out.println("Table body'de Toplam "+driver.findElements(By.xpath("//tbody//tr")).size()+
                " tane satir(row) vardir");
        System.out.println("\n  ===Table body'deki Bütün Satirlar(Rows)====");
        List<WebElement> allRows=driver.findElements(By.xpath("//tbody//tr"));
      for (WebElement row:allRows){
          System.out.println(row.getText());

      }
        //4.ROW elementleri
        System.out.println("\n    =====Row4 elementleri=====");
        List<WebElement> elementsRow4=driver.findElements(By.xpath("//tr[4]//td"));
        for (WebElement element:elementsRow4){
            System.out.print(element.getText()+" ** ");
        }
    }
    //printCells() metodu oluşturun
    //table body’sinde bulunan toplam hücre(cell) sayısını bulun.//td
    //Table body’sinde bulunan hücreleri(cells)  konsolda yazdırın.
    @Test
    public void printCells(){
        login();

        System.out.println("Tabloda toplam "+ driver.findElements(By.xpath("//tbody//td")).size()+" tane cell(hücre) vardir");
        System.out.println("\nBody deki Elementler");
        List<WebElement> allCell= driver.findElements(By.xpath("//tbody//td"));
        for(WebElement cell:allCell){
            System.out.println(cell.getText());
        }

    }


    //printColumns() metodu oluşturun
    //table body’sinde bulunan toplam sutun(column) sayısını bulun.
    //Table body’sinde bulunan sutunlari(column)   konsolda yazdırın.
    //5.column daki elementleri  konsolda yazdırın.

    @Test
    public void printColumns(){
        login();
        System.out.println("Tabloda toplam "+driver.findElements(By.xpath("//tr[3]//td")).size()+" tane sütun(column) vardir");

        //Table body’sinde bulunan sutunlari(column)   konsolda yazdırın.
     //   List<WebElement> allColumn = driver.findElements(By.xpath("//th"));
     //   for (WebElement column : allColumn) {
     //       System.out.println(column.getText());
     //   }

        //5.column daki elementleri  konsolda yazdırın.
        List<WebElement> column5=driver.findElements(By.xpath("//tbody//td[5]"));
        for(WebElement element:column5){
            System.out.println(element.getText());
        }

        }
//WebTables class’ini kullanin.
//Bir metod oluşturun : printData(int row, int column);
//Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu hücredeki(cell) veriyi yazdırmalıdır.
//Baska bir metod daha oluşturun: printDataTest();
//Ve bu metodu printData() methodunu cagirmak icin kullanin.
//Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır


        public void printData(int row, int column){
        //Kodlari bu methodun icine yazalim
        //     //tbody//tr[8]//td[3] gibi olmali
            String xpath="//tbody//tr["+row+"]//td[" +column+"]";//cift tirnaklar concatination icin yazildi
            WebElement data = driver.findElement(By.xpath(xpath));
            //data lari yazdiralim
            System.out.println(data.getText());


        }

        @Test
    public void printDataTest(){
        login();
        printData(8,3);//1234
        printData(5,2);//kalem
        printData(9,5);//London



        }


}
