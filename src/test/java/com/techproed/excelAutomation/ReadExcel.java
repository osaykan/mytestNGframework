package com.techproed.excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel {
    //Data Driven Testing-DDT(Veriye dayali testler) yapmak icin excel otomasyonunu kullaniriz
    //Harici(external) kaynaktan(excel) veri aldiginizda bu islem DDT olarak bilinir.

    //Workbook(Dosyanin kendisi) > Worksheet(acilinca icindeki sayfalar) >Row(satir) > Cell(hücre)
    //Java hücre varsa sayar.
    //Excel package olustur==>ReadExcel classi olustur

    @Test
    public void readExcelFile() throws IOException {
        //Masa üstündeki excelden veri okumak icin path yazalim
        String path ="C:\\Users\\Mz\\Desktop\\ULKELER.xlsx";

        //Dosyayi(File) acalim
        FileInputStream fileInputStream=new FileInputStream(path);  //Kirmizilik icin exception ekledik
       // fileInputStream kullanarak workbook'u acalim.  Kütüphaneye dependency eklemeliyiz(Apache POI)
        //https://mvnrepository.com gitmeliyiz
        Workbook workbook= WorkbookFactory.create(fileInputStream);//Workbooku actik. Exception yaptik
        //1.worksheete gidelim
        Sheet sheet=workbook.getSheetAt(0);//indexs
        //1.satira(row) gidelim
        Row row=sheet.getRow(0);//index sifirdan baslar
        //Artik test datalarini(cell) okuyab iliriz

        Cell cell = row.getCell(0);
        System.out.println("1. Celldeki Data : "+cell);  //1. Celldeki Data : ULKELER
        System.out.println("2.CELLDEKI DATA : "+row.getCell(1));//2.CELLDEKI DATA : BASKENT

        //2.row'daki 1.cell'i konsola yazdirin

        Row row2=sheet.getRow(1);
        Cell cell1= row2.getCell(0);
        System.out.println(cell1);     //Almanya
        //veya chain methodu
        System.out.println(workbook.getSheetAt(0).getRow(1).getCell(0));//Almanya
        //veya chain methodu
        String row2cell1=workbook.getSheetAt(0).getRow(1).getCell(0).toString();
        System.out.println(row2cell1);

        //Son row(satir) numarasini alalim.(index sifirdan basliyor)
        int rowSayisi=sheet.getLastRowNum();
        System.out.println(rowSayisi);   //999 cikti yanlis ama düzelmedi. Webden indirilen excel baska excel yapistirdim 9

        //Kullanilan(icinde veri olan) satirlarin sayisini nasil aliriz(indexs 1 den baslar)
      int numberofPhysicalPows=  sheet.getPhysicalNumberOfRows();
        System.out.println(numberofPhysicalPows); //1000  baska excel yapistirdim 10

        Map<String, String > ulkeler = new HashMap<>();
        int ulkeColumn = 0;
        int baskentColumn = 1;
        for( int rowNum = 1 ; rowNum<= rowSayisi ; rowNum++){
            String ulke = sheet.getRow(rowNum).getCell(ulkeColumn).toString();
            System.out.print(ulke+"  ");
            String baskent = sheet.getRow(rowNum).getCell(baskentColumn).toString();
            System.out.println(baskent);
            //hashmap olarak nasil yazdirabilirim???
            ulkeler.put(ulke,baskent);
        }
        System.out.println(ulkeler);


    }
}
