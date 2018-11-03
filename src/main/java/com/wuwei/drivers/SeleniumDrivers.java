package com.wuwei.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumDrivers {
     public static WebDriver driver;
    public static WebDriver openBrower(String brower){
       String path= System.getProperty("user.dir");//获取当前项目路径地址
        if(brower.equals("chrome")){
            System.setProperty("webdriver.chrome.driver",path+"/webdrivers/chromedriver.exe");
            driver=new ChromeDriver();
        }else if(brower.equals("firefox")){
            driver=new FirefoxDriver();
        }else {
            System.out.println("浏览器传入有误"+brower);
        }
        return  driver;
    }

    public static void  closeBrower(){
       driver.quit();
    }

}
