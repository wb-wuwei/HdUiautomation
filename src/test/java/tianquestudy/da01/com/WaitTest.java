package tianquestudy.da01.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        //设置webdriver路径
        System.setProperty("webdriver.chrome.driver","D:\\Ideaprojects\\webdrivers\\chromedriver.exe");
        //打开浏览器
        driver =new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test
    public  void waitTest(){
        driver.get("http://47.98.99.92/tianquestudy/");
        driver.findElement(By.className("wait")).click();
        WebDriverWait wait=new WebDriverWait(driver,20);
       String string= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div"))).getText();
        System.out.println(string);
    }


}
