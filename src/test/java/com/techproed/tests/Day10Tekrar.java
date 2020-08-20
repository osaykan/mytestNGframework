package com.techproed.tests;

import com.google.gson.internal.$Gson$Preconditions;
import org.testng.annotations.*;

public class Day10Tekrar {
    // //1-@AfterMethod,@BeforeMethod seklinde yazilir. JUnit de sadece @After ve @Before seklinde idi
    //  //2-@BeforeGroups
    //  //3-@BeforeClass, clasin öncesinde
    //  //4- @BeforeTest,
    //  //5- @BeforeSuit
    //  //siralama kücükten büyüge dogru
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @Test(priority = 3)
    public void test1(){
        System.out.println("Test1");
    }
    @Test(priority = 2,dependsOnMethods = "test1")
    public void test2(){
        System.out.println("Test2");
    }
    @Test(priority = 1)
            public void test3() {


        System.out.println("Test3");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After method");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After class");
    }
}
