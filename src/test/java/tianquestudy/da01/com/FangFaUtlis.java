package tianquestudy.da01.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FangFaUtlis {
    public static void login(WebDriver driver,String name, String pwd,String buttn){
        driver.findElement(By.id("username")).sendKeys(name);
        driver.findElement(By.id("password")).sendKeys(pwd);
        driver.findElement(By.id("buttn")).click();
    }

    public static void wait(WebDriver driver,long time,By by){
        WebDriverWait driverWait=new WebDriverWait(driver,time);
        String string=  driverWait.until(ExpectedConditions.presenceOfElementLocated(by)).getText();
    }

}
