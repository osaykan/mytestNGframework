package com.techproed.excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class Day22_01WriteExcel {
    @Test
    public void writeExcel() throws IOException {
        String path =  ".\\src\\test\\resources\\ULKELER.xlsx";
        //"C:\\Users\\Mz\\Desktop\\ULKELER.xlsx";  önce bu yaziliydi.exceli freamworke tasiyinca copy==>absolutepath al
        // ve buraya yazdik
        //src den önceki yeri silip yerine nokta yazdik
        FileInputStream file=new FileInputStream(path);      //file acalim
        Workbook workbook= WorkbookFactory.create(file);   //workbooku acalim
        Sheet sheet=workbook.getSheetAt(0);            //1.sheete git
        Row row=sheet.getRow(0);                     //1.rowa git(basliklar)


        FileOutputStream fileOutputStream=new FileOutputStream(path);

        Cell cell=row.createCell(3);              //create cell
        cell.setCellValue("NUFUS");

        Cell cell5=row.createCell(4);
        cell5.setCellValue("YUZOLCUMU");            //yazdik
       row.removeCell(cell5);                      //sildik

        workbook.getSheetAt(0).getRow(1).createCell(3).setCellValue("12345678");
        workbook.getSheetAt(0).getRow(2).createCell(3).setCellValue("72345678");
        workbook.getSheetAt(0).getRow(3).createCell(3).setCellValue("82345678");


        workbook.write(fileOutputStream);//ustteki satirdan sonra olmali.veri yazar ve kaydeder.
        //main'in altindaki test==>new==>Directory(yoksa packageyi sec)==>resources yaz dosya olusturduk package
        //Exceli masa üstünden freamworke tasimak istiyoruz.
        //masa üstündeki exceli sürükleyecegiz ve resourcenin icine birak==>refactor.


        //smoketest.xml dosyasi olusturduk (yeni konu)

        fileOutputStream.close();    //Kapatmamiz gerekir,tekrar acabilmemiz icin
        file.close();
        workbook.close();


    }
}
