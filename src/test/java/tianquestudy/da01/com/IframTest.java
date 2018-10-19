package tianquestudy.da01.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        //设置webdriver路径
        System.setProperty("webdriver.chrome.driver","D:\\Ideaprojects\\webdrivers\\chromedriver.exe");
        //打开浏览器
        driver =new ChromeDriver();
    }
    @Test
    public void iframeTest1() throws InterruptedException {
        //iframe窗口的跳转
        driver.get("http://47.98.99.92/tianquestudy/");
        driver.findElement(By.id("user")).sendKeys(" wo lai le iframe");
        //把控制权转交给iframe界面
        WebElement element= driver.findElement(By.xpath("/html/body/div/table/tbody/tr[15]/td[2]/iframe"));
        driver.switchTo().frame(element);
        //点击iframe窗口的Linktext为baidu的按钮
        driver.findElement(By.linkText("baidu")).click();
        //把控制权回到顶部页面
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        driver.findElement(By.id("user")).clear();
        driver.findElement(By.id("user")).sendKeys("this is another iframe");
    }
    @Test
    public void selectTest() throws InterruptedException {
        //下拉框选择,有如下三种方式获取定位，index,value,visibleText
        driver.get("http://47.98.99.92/tianquestudy/");
        WebElement element = driver.findElement(By.id("moreSelect"));
        Thread.sleep(2000);
        Select select = new Select(element);
        select.selectByIndex(3);
        Thread.sleep(2000);
        //select.selectByValue("xxxx");       //value值
        //select.selectByVisibleText("xxxxxx");  //文本值
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
