package regiestrationForm.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class Driver {
   //singleton design pattern driver instance should be private
    private Driver() {
    }

    //instantiate driver object
    private static WebDriver driver;

    // public static getter method

    public static WebDriver getDriver() {
       switch (ConfigurationReader.get("browser")){
           case "chrome":
               if(driver == null || ((ChromeDriver)driver).getSessionId() == null){
                   WebDriverManager.chromedriver().setup();
                   driver = new ChromeDriver();
               }
               break;
           case "chrome-headless":
               if(driver == null || ((ChromeDriver)driver).getSessionId() == null){
                   WebDriverManager.chromedriver().setup();
                   driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
               }
               break;
           case "firefox":
               if(driver == null || ((FirefoxDriver)driver).getSessionId() == null){
                   WebDriverManager.firefoxdriver().setup();
                   driver = new FirefoxDriver();
               }
               break;
           case "firefox-headless":
               if(driver == null || ((FirefoxDriver)driver).getSessionId() == null){
                   WebDriverManager.firefoxdriver().setup();
                   driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
               }
               break;
       }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}