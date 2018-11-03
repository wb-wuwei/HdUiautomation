package com.wuwei.drivers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SeleniemDriversTest {

    @Test
    public void  tets1(){
      WebDriver driver= SeleniumDrivers.openBrower("chrome");
        driver.get("https://www.baidu.com/");
        SeleniumDrivers.closeBrower();
    }
}
