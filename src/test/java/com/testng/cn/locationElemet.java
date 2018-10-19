package com.testng.cn;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class locationElemet {
    WebDriver driver;
    @BeforeMethod
    public  void cpenChrome(){
        //设置webdriver路劲
        System.setProperty("webdriver.chrome.driver","D:\\Ideaprojects\\webdrivers\\chromedriver.exe");
        //打来浏览器
        driver=new ChromeDriver();
    }
    @Test
    public void findName(){
        //输入百度地址
        driver.get("http://www.baidu.com");
        //通过name 查找
        WebElement we =driver.findElement(By.name("wd"));
    }
    //通过id 查找
    @Test
    public void findId() throws InterruptedException {
        driver.get("http://www.baidu.com/");
        //定位到这个地方，然后右键点击检查，此处也可以用name,
        WebElement element1=driver.findElement(By.id("kw"));
        //往百度搜索框输入selenium
        element1.sendKeys("selenium");
        driver.findElement(By.id("su")).click();
        Thread.sleep(5000);
        element1.clear(); //清空刚才输入的内容
    }
    //通过LinkText查找, 只能查找出标签中间的值
    @Test
    public  void findLinkText(){
        driver.get("http://www.baidu.com");
        WebElement element=driver.findElement(By.linkText("新闻"));
        element.click();
    }
    //getTagName 是获取标签
    @Test
    public void getGetTagName(){
        driver.get("http://www.baidu.com");
       String s= driver.findElement(By.id("kw")).getTagName();
        System.out.println(s);

    }

    //获取某个属性的某个值
    @Test
    public void  getGetAttribute(){
        driver.get("http://www.baidu.com");
        String s=driver.findElement(By.id("su")).getAttribute("value");
        System.out.println(s);
    }
    //isDisplayed判断一个元素是否展示
    @Test
    public void isDisplayed(){
        driver.get("http://www.baidu.com");
        //判断百度一下按钮是否显示
        boolean b=driver.findElement(By.id("su")).isDisplayed();
        System.out.println(b);  //这里输出的是true
        Assert.assertTrue(b,"校验百度一下按钮是否显示");
    }

    @Test
    //webdriver 自带截图方法
    public  void jieTu(){
        //打开百度
        driver.get("http://www.baidu.com");
        //截图操作
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("D:\\ceshi.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //弹窗处理  点击确定按钮Alert
    @Test
    public void alterTest(){
        driver.get("http://baidu.com");
        driver.findElement(By.id("kw")).click(); //这里不会有弹窗  只是例子
        Alert a=driver.switchTo().alert();
        a.accept();
    }

    @Test
    public void disMissTest(){
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("kw")).click();
        Alert a=driver.switchTo().alert();
        a.dismiss();//操作弹窗取消按钮
    }

    @AfterMethod
    public void closeChrom(){
        driver.quit();
    }


}
