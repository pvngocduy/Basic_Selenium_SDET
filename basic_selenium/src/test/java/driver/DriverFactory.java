package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {
    // DriverFactory.getChromeDriver()
    public static WebDriver getChromeDriver(){
        //Specify ChromeDriver Option
        String currentProjectLocation = System.getProperty("user.dir");
        String chromeDriverLocation = "";
        if(OS.isFamilyMac()){
            chromeDriverLocation = currentProjectLocation + "/src/test/resources/driver/chromedriver";
        }
        if(OS.isFamilyWindows()){
            chromeDriverLocation = currentProjectLocation + "\\src\\test\\resources\\driver\\chromedriver.exe";
        }
        if (chromeDriverLocation == null){
            throw new IllegalArgumentException("Cant detect current OS");
        }
        System.setProperty("webdriver.chrome.driver",chromeDriverLocation);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        //Session intilization
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
    }
}
