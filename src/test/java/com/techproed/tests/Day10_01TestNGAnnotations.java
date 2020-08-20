package com.techproed.tests;

import org.testng.annotations.*;

public class Day10_01TestNGAnnotations {     //Project olusturunca ilk defa acarken seleniun java, webdrivermanager
                                    //ve testNG dependency leri mvnrepository.com dan getirip pom a ilave ediyoruz
  //1-@AfterMethod,@BeforeMethod seklinde yazilir. JUnit de sadece @After ve @Before seklinde idi
  //2-@BeforeGroups
  //3-@BeforeClass, clasin öncesinde
  //4- @BeforeTest,
  //5- @BeforeSuit
  //siralama kücükten büyüge dogru

  //TestNG de ciktilar alfabetik siraya göre siralar.JUnit de rast gele .
  //@Test(periority==1) gibi yazarak siralamayi kendimize göre yapabiliriz
  @Ignore   //Ignor, test yapilan yerlerde(run) calisir burada etkilemez.@Test metodunun basina
            //yazilsaydi bu methodu göstermezdi
  @BeforeTest
  public void beforeTest(){                    //====================> 1.calisir basta birkez
    System.out.println("====Before TEST=========");
  }
  @BeforeClass                               //======================>2.calisir basta birkez
  public void BeforeClass(){
    System.out.println("====>Before Class<======");  //Clasin basinda yazar bir kere
  }

  @BeforeMethod
  public void beforeMethod(){              //=======================>3.calisir her methodttan önce
    System.out.println("===Before Method=====");
  }


  @Test
  public void test1(){
    System.out.println("Bu Test1 Methodudur");

  }
  @Test
  public void test2(){
    System.out.println("Bu Test2 Methodudur");

  }


  @Test
  public void test3(){

    System.out.println("Bu Test3 Methodudur");
  }
  @AfterMethod
  public void afterMethod(){             //AfterMethod her methodun sonunda yazar
    System.out.println("====After Method===");
  }
  @AfterClass
  public void afterClass(){         //AfterClass class'in sonunda bir kez yazar
    System.out.println("====After Class========");
  }
  @AfterTest
  public void afterTest(){
    System.out.println("====After TEST");
  }


}
