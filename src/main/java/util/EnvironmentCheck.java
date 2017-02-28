//package util;
//
//import java.io.File;
//
//import org.apache.commons.lang3.SystemUtils;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//// FIXME
//public class EnvironmentCheck {
//
//    private WebDriver driver;
//    private Wait<WebDriver> wait;
//
//    // IEDriverServer.exe
//
//    private String chromeDriverPath() {
//        String path;
//        if (SystemUtils.IS_OS_MAC || SystemUtils.IS_OS_MAC_OSX) {
//            path = "chromedriver/mac/chromedriver"; // Mac環境の場合
//        } else {
//            path = "chromedriver/win/chromedriver.exe"; // Windows環境の場合
//        }
//        File file = new File(path);
//        return file.getAbsolutePath();
//    }
//
//    private String ieDriverPath() {
//        String path;
//        if (SystemUtils.IS_OS_MAC || SystemUtils.IS_OS_MAC_OSX) {
//            path = "iedriver/mac/IEDriverServer"; // Mac環境の場合
//        } else {
//            path = "iedriver/win/IEDriverServer.exe"; // Windows環境の場合
//        }
//        File file = new File(path);
//        return file.getAbsolutePath();
//    }
//
//    @Before
//    public void setUp() {
//        // System.setProperty("webdriver.chrome.driver", chromeDriverPath());
//        // System.out.println(System.getProperty("webdriver.chrome.driver"));
//        // driver = new ChromeDriver();
//
//        System.setProperty("webdriver.ie.driver", ieDriverPath());
//        System.out.println(System.getProperty("webdriver.ie.driver"));
//
//        driver = new InternetExplorerDriver();
//        wait = new WebDriverWait(driver, 30);
//    }
//
//    @After
//    public void tearDown() {
//        driver.quit();
//    }
//
//    @Test
//    public void check() {
//        File html = new File("introWork/introWork1.html");
//        String url = "file:///" + html.getAbsolutePath();
//        driver.get(url);
//        WebElement userName = driver.findElement(By.id("user_name"));
//        userName.sendKeys("TestUser");
//        WebElement password = driver.findElement(By.id("password"));
//        password.sendKeys("pass");
//        WebElement login = driver.findElement(By.id("login"));
//
//        login.click();
//
//        // http://yyyank.blogspot.jp/2015/02/selenium-webdriverwaitcustomcondition.html 条件カスタム方法
//        // unitl引数がtrueになるまで待つ
//        // alertが表示されるまで待つ
//        wait.until(ExpectedConditions.alertIsPresent());
//        driver.switchTo().alert().accept();
//
//        System.out.println(driver.getCurrentUrl());
//    }
//}
