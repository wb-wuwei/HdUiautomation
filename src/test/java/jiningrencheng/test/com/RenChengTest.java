package jiningrencheng.test.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tianquestudy.da01.com.FangFaUtlis;

public  class RenChengTest {
    WebDriver  driver;
    @BeforeMethod
    public  void opChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\Ideaprojects\\webdrivers\\chromedriver.exe");
         driver=new ChromeDriver();
        driver.get("http://192.168.100.13:8080/login.jsp");
    }
    @Test
    public void login(){
        driver.findElement(By.id("username")).sendKeys("wuwei");
        driver.findElement(By.id("password")).sendKeys("11111111");
        driver.findElement(By.id("submitButton")).click();
        WebDriverWait driverWait=new WebDriverWait(driver,20);
       String string=  driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("智慧社区管理-综合信息系统"))).getText();
        Assert.assertEquals(string,"智慧社区管理-综合信息系统");
    }

    @Test
    public void errorLogin(){
        FangFaUtlis.login(driver,"wuwei1","11111111","submitButton");
       String string= driver.getWindowHandle();
       for (String str : driver.getWindowHandles()){
            if (str.equals(string)){
                continue;
            }else {
                driver.switchTo().window(string);
            }
       }
    }

    @DataProvider(name = "renchenglogin")
    public  Object[][] dataMothed(){
        return new Object[][]{
                {"wuwei","11111111"},
                {"wuwei1","11111111"},
                {"wuwei"," "},
                {"!@#","111111"}
        };
    }

    @Test(dataProvider = "renchenglogin")
    public void testDateLogin(String name,String pwd){
        FangFaUtlis.login(driver,name,pwd,"submitButton");
    }

    @AfterMethod
    public void  closeChrome() throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();

    }

}
