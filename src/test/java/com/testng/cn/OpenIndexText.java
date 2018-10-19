package com.testng.cn;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

public class OpenIndexText {
    WebDriver driver;
    @BeforeMethod
    public  void openChrom(){
        System.setProperty("webdriver.chrome.driver","D:\\Ideaprojects\\webdrivers\\chromedriver.exe");
         driver=new ChromeDriver();
    }

    @Test
    public void openIndex() throws InterruptedException {
        driver.get("file:///E:/selenium_html/index.html");
      //找到input输入况输入
        driver.findElement(By.id("user")).sendKeys("ceshi");
        Thread.sleep(2000);
    }
    @Test
    public void selectTest(){
        //选择select下拉框
        driver.get("file:///E:/selenium_html/index.html");
        WebElement element= driver.findElement(By.id("moreSelect"));
        Select select=new Select(element);
        //方式一 通过索引查找，从0开始
        select.selectByIndex(2);
        //方式2 通过value值查找
       // select.selectByValue("xiaomi");
        //方式三通过文本值查找
        //select.selectByVisibleText("huawei");
        //截图方法
       File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("D:\\testing\\webdriver_demo\\baidu.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void alertTest() throws InterruptedException {
        driver.get("file:///E:/selenium_html/index.html");
        WebElement element= driver.findElement(By.className("alert"));
        element.click();
        //移交权限
        Alert alert=driver.switchTo().alert();
        alert.accept();
        Thread.sleep(3000);
    }
    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("file:///E:/selenium_html/index.html");
        driver.findElement(By.id("user")).sendKeys("this is iframe");
        Thread.sleep(3000);
        //把控制权转交给iframe界面，，id或者属性值为aa的iframe窗口,下面一个方法是没有Id和属性值的情况
        driver.switchTo().frame("aa");
        System.out.println("------------------------------");
        Thread.sleep(3000);
        //点击iframe窗口的Linktext为baidu的按钮
        driver.findElement(By.linkText("baidu")).click();
        Thread.sleep(5000);
        //把控制权回到顶部页面
//        driver.switchTo().defaultContent();
//        Thread.sleep(3000);
//        driver.findElement(By.id("user")).clear();
//        driver.findElement(By.id("user")).sendKeys("this is another iframe");


    }

    @Test
    public void confirmTest(){
        driver.get("file:///E:/selenium_html/index.html");
        driver.findElement(By.xpath("//*[@id=\"confirm\"]/input")).click();
        Alert alert= driver.switchTo().alert();
        alert.dismiss();
        alert.accept();
       File file= ( (TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("E:\\ceshi.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void openWindows(){
        driver.get("file:///E:/selenium_html/index.html");
        driver.findElement(By.linkText("Open new window")).click();
        String hadle=driver.getWindowHandle();
        for(String string : driver.getWindowHandles()){
            if(string.equals(hadle)){
                continue;
            }else {
                driver.switchTo().window(string);
            }
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.linkText("baidu")).click();
    }
    @AfterMethod
    public void close() throws InterruptedException {
        driver.quit();
        Thread.sleep(3000);
}}
