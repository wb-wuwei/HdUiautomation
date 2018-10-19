package com.testng.cn;

import org.testng.annotations.*;

public class TestNgDemo1 {
    @BeforeClass
    public  void  beforClass(){
        System.out.println("这是beforClass");
    }
    @BeforeMethod
    public void beforMethond(){
        System.out.println("这是beforMethond");
    }
    @Test
    public void beforTest2(){
        System.out.println("这是Test 测试1");
    }

    @Test
    public void beforTest1(){
        System.out.println("这是Test 测试2");
    }
    @Test
    public void abeforTest3(){
        System.out.println("这是test 测试3");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("这是afterClass");

    }
    @AfterMethod
    public void aftermMethod(){
        System.out.println("这是aftermMethod");
    }

}
