package com.testng.cn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class OpenFireFox {
    //默认打开
    @Test
    public void openFirefox(){

        WebDriver webDriver=new FirefoxDriver();
    }

    @Test
    //根据不同安装目录打开
    public void openFF(){
        System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        WebDriver webDriver=new FirefoxDriver();
    }

    @Test
    public  void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\Ideaprojects\\webdrivers\\chromedriver.exe");
        WebDriver wbd=new ChromeDriver();
    }
}
