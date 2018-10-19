package tianquestudy.da01.com;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebUiPractice {
    WebDriver driver;
    @BeforeMethod
    public void opChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\Ideaprojects\\webdrivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://47.98.99.92/tianquestudy/");
    }

    @Test
    public void inputTest() throws InterruptedException {
        driver.findElement(By.id("user")).sendKeys("wuwei");
        Thread.sleep(2000);
        driver.findElement(By.linkText("登陆界面")).click();
        driver.navigate().back();
      WebElement webElement= driver.findElement(By.id("moreSelect"));
        Select select =new Select(webElement);
        select.selectByValue("chongqing");
        //select.selectByIndex(2);//通过索引查找
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("D:\\testing\\webdriver_demo\\webui.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void danXuan() throws InterruptedException {
        //遍历单选框
       ArrayList<WebElement> webElements = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@id=\"radio\"]/input"));
       for (WebElement webElement : webElements){
           webElement.click();
           Thread.sleep(2000);
       }
    }

    @Test
    //遍历多选
    public void duoXuan() throws InterruptedException {
        List<WebElement>webElements=driver.findElements(By.xpath("//*[@id=\"checkbox\"]/input"));
        for (WebElement webElement : webElements){
            webElement.click();
            Thread.sleep(2000);
        }
    }

    @AfterMethod
    public void closeChrome() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
