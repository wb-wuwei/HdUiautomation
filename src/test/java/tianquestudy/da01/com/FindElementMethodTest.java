package tianquestudy.da01.com;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

public class FindElementMethodTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        //设置webdriver路径
        System.setProperty("webdriver.chrome.driver","D:\\Ideaprojects\\webdrivers\\chromedriver.exe");
        //打开浏览器
        driver =new ChromeDriver();
    }
    /**
     * 通过id查找
     */
    @Test
    public void openIndex() throws InterruptedException {
        driver.get("http://47.98.99.92/tianquestudy/");
        //找到input输入ceshi
        driver.findElement(By.id("user")).sendKeys("ceshi");
        Thread.sleep(2000);
    }
        /**
     * 通过name查找
     */
    @Test
    public void findName(){
        //输入百度地址
        driver.get("http://www.baidu.com");
        //通过name 查找
        WebElement we =driver.findElement(By.name("wd"));
    }
    /**
     * 通过LinkText查找, 只能查找出标签中间的值
     */
    @Test
    public  void findLinkText(){
        driver.get("http://47.98.99.92/tianquestudy/");
        WebElement element=driver.findElement(By.linkText("登陆界面"));
        element.click();
    }
    /**
     * getTagName 获取标签
     */
    @Test
    public void getGetTagName(){
        driver.get("http://47.98.99.92/tianquestudy/");
        String s= driver.findElement(By.id("user")).getTagName();
        System.out.println(s);
    }
    /**
     * 获取某个属性的某个值
     */
    @Test
    public void  getGetAttribute(){
        driver.get("http://47.98.99.92/tianquestudy/");
        String s=driver.findElement(By.className("prompt")).getAttribute("value");
        System.out.println(s);

    }

    /**
     * webdriver 自带截图方法
     */
    @Test
    public  void jieTu(){
        //打开百度
        driver.get("http://47.98.99.92/tianquestudy/");
        //截图操作
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("D:\\ceshi.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
