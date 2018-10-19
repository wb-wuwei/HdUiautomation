package tianque.jiangsu.cn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenJangSu {
    WebDriver driver;
    @BeforeMethod
    public void opneChrom(){
        System.setProperty("webdriver.chrome.driver","D:\\Ideaprojects\\webdrivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    @Test
    public void login() throws InterruptedException {
        driver.get("http://192.168.100.251:8090");
        driver.findElement(By.id("username")).sendKeys("wange@csqxsg");
        driver.findElement(By.id("password")).sendKeys("11111111");
        Thread.sleep(2000);
        driver.findElement(By.id("submithref")).click();
            Thread.sleep(4000);
        driver.findElement(By.id("serviceWorkId")).click();
            Thread.sleep(3000);
        String name=driver.findElement(By.xpath("//*[@id=\"ext-gen6\"]/div[2]/div[1]/div[7]/ul/li[2]/div/span[1]")).getText();
        System.out.println("-------------------"+name+"---------------------------------");
      Assert.assertEquals("布吉岛",name);
    }
    @AfterMethod
    public void  close() throws InterruptedException {
        driver.quit();
        Thread.sleep(3000);
    }
}
