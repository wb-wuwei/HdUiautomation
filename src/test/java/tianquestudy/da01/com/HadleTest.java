package tianquestudy.da01.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HadleTest {
    WebDriver driver;
    @BeforeMethod
    public  void openChrom(){
        System.setProperty("webdriver.chrome.driver","D:\\Ideaprojects\\webdrivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }
    @Test
    public void openWindows(){
        driver.get("http://47.98.99.92/tianquestudy/");
        driver.findElement(By.linkText("打开新网页")).click();
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
}
