package com.testng.cn;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 浏览器刷新
 driver.navigate().refresh();
 浏览器最大化
 driver.manage().window().maximize();
 设置浏览器大小
 Dimension dimension = new Dimension(900, 800);
 driver.manage().window().setSize(dimension);
 获取当前页面URL
 driver.getCurrentUrl();
 获取当前页面Title
 driver.getTitle();
 */
public class OpenChromeTest {
    WebDriver driver; //提取出来，下面@test测试方法中及@AfterMethod中也有用到  所有提取出来作为成员变量

    @BeforeMethod
    /**每个测试方法都需要打开浏览器，所以提取出来写在@beformethod中， 因为被@beformethod注解的方法
     在执行每个@test时都会被执行
     */
    public void openChrome(){
        //设置webdriver路径
        System.setProperty("webdriver.chrome.driver","D:\\Ideaprojects\\webdrivers\\chromedriver.exe");
        //打开浏览器
        driver =new ChromeDriver();

    }
    @Test
    public  void openChore() throws InterruptedException {
        //输入地址
        driver.get("https://www.baidu.com");
        //等待5秒, 使用try..catch抛异常,也可以使用throws抛异常
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //后退操作
        driver.navigate().back();
        //等待三秒
        Thread.sleep(3000);
        //前进操作
        driver.navigate().forward();
        //刷新操作
        driver.navigate().refresh();
    }

    @Test
    public void openChrome1(){
        //输入百度地址
        driver.get("https://www.baidu.com/");
      //获取地址
       String addres= driver.getCurrentUrl();
        System.out.println("------"+addres+"---------");
        //判断当前地址是否为百度地址
        Assert.assertEquals(addres,"https://www.baidu.com/");
    }


    public void closeChromme(){
        //关闭浏览器
        driver.quit();
    }
}
