package com.techproed.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
 //Bu class'in amaci configuration.properties dosyasindaki verileri(test data) okumaktir.
    //create Properties instance
    private static Properties properties;
    //FileInputStream kullanarak bir dosya aciyoruz
    //Properties'i bu dosyaya yüklüyoruz
    //Daha sonra properties dosyasini okuyacagiz

    //baslatmak icin static blok olusturduk
    //ConfigReader classini okumak icin static blok kullanilir(interviev)

    static{
        //configuration.properties pathinin son kismini al
        String path ="configuration.properties";
        //FileInputStream file =new FileInputStream(path); yazinca kirmizi cizgi try catch istiyor
        try {
            FileInputStream file =new FileInputStream(path);//FileInputStream kullanarak bir dosya aciyoruz
            properties=new Properties();
            properties.load(file);  //kirmizi icin add catch yapiyoruz
        } catch (Exception e) {    //Exception parent oldugu icin onu yazip altta olusan catch kismini siliyoruz
            System.out.println("file path bulunamadi");
            e.printStackTrace();
        }


    }

    //Okumak icin static bir method olusturalim
    //Bu method kullanici anahtar kelimeyi girdiginde(key), value return eder.
    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
