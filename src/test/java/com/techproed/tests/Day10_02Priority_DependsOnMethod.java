package com.techproed.tests;

import org.testng.annotations.Test;

public class Day10_02Priority_DependsOnMethod {//Sadece Test ler olursa alfabetik siraya göre hompage,log,res,search
    //(priority = 1) verilirse verilmeyenler daha önce calistiriyor sonra prioroty sirasina göre calistiriyor

    @Test(priority = 3)
    public void login(){
        System.out.println("Bu method login methodu");

    }
    @Test(priority = 2 , dependsOnMethods = "login")    //dependsOnMethods = "login"  sayet login method PASS olursa bu method calisacak
                                                        //Aksi taktirde atlayacak. Ignore bagli olanlari calistirmiyor
    public void homePage(){
        System.out.println("Bu method homepage methodu");

    }
    @Test(priority = 3)
    public void search(){
        System.out.println("Bu method search methodu");

    }
    @Test(priority = 4)
    public void result(){
        System.out.println("Bu method result methodu");

    }
    // dependsOnMethods = "hongi Method'a bagli calismasini istedigimiz MethodIsmi" yazilir.
// bagladigimiz method'i @Ignore yaparsak ikisi de calismamis olacak.
// Bagli olan Methodu calistirdigimizda ise Bagli olan Method ve Baglanan Method ikisi de calisir.


}
