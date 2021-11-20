package api_learning;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class StartBrowser implements Urls {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(baseUrl);
        Thread.sleep(2000);
        driver.quit();
    }
}
