package tianquestudy.da01.com;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenChromeTest {
    WebDriver driver; //提取出来，下面@test测试方法中及@AfterMethod中也有用到  所有提取出来作为成员变量

    @BeforeMethod
    public void openChrome(){
        //设置webdriver路径
        System.setProperty("webdriver.chrome.driver","D:\\Ideaprojects\\webdrivers\\chromedriver.exe");
        //打开浏览器
        driver =new ChromeDriver();

    }
    @Test
    public  void openChore() throws InterruptedException {
        //输入地址
        driver.get("http://47.98.99.92/tianquestudy/");
        driver.findElement(By.id("id01")).click();
        Thread.sleep(2000);
        WebDriverWait wdb=new WebDriverWait(driver,10);
        //后退操作
        driver.navigate().back();
        Thread.sleep(1000);
        //前进操作
        driver.navigate().forward();
        //刷新操作
        driver.navigate().refresh();
    }

    @Test
    public void openChrome1(){
        //输入百度地址
        driver.get("http://47.98.99.92/tianquestudy/");
      //获取地址
       String addres= driver.getCurrentUrl();
        System.out.println("------"+addres+"---------");
        //判断当前地址
        Assert.assertEquals(addres,"http://47.98.99.92/tianquestudy/");
    }

    @AfterMethod
    public void closeChromme(){
        //driver.close();//关闭当前窗口进程还在,不建议使用
        driver.quit(); //关闭浏览器
    }
}
