package utils;

import Steps.PageInitializer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.lang.runtime.SwitchBootstraps;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializer {

  public static WebDriver driver;

  public static void openBrowser() {
    ConfigReader.readProperties(Constants.ConfigPropertiesPath);
    switch (ConfigReader.getPropertyValue("browser")) {
      case "chrome":
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        break;
      case "firefox":
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        break;
      default:
        throw new RuntimeException("Invalid browser");
    }
    driver.manage().window().maximize();
    driver.get(ConfigReader.getPropertyValue("url"));
    driver.manage().timeouts().implicitlyWait(Constants.implicitWait, TimeUnit.SECONDS);
    initializePageObjects();

  }

  public static void closeBrowser() {
    driver.quit();

  }

  public static WebDriverWait waitDriver() {
    WebDriverWait wait = new WebDriverWait(driver, Constants.explicitWait);
    return wait;
  }

  public static void clickAbilityWait(WebElement element) {
    waitDriver().until(ExpectedConditions.elementToBeClickable(element));


  }

  public static void click(WebElement element) {
    clickAbilityWait(element);
    element.click();


  }

  public static void sendKeys(WebElement element, String textToSend) {
    element.clear();
    element.sendKeys(textToSend);
  }

  public static void select(WebElement element, String textToSend) {
    Select select = new Select(element);
    select.selectByVisibleText(textToSend);


  }

  public static void screenShot() {

  }

  public static void jsClick(WebElement element) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].click();", element);
  }

  public static byte[] takeScreenshot(String fileName) {
    TakesScreenshot ts = (TakesScreenshot) driver;
    byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
    File sourceFile = ts.getScreenshotAs(OutputType.FILE);

    //how to name the screenshot

    try {
      FileUtils.copyFile(sourceFile, new File(Constants.screenShotFilePath+ fileName +
              " " + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return picBytes;
  }

  public static String getTimeStamp(String pattern) {
    Date date = new Date();
    //to format the date according to the choice of our own
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    return sdf.format(date);
  }
}