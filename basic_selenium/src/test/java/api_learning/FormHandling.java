package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormHandling implements Urls {
    private static By usernameSel = By.id("username");
    private static By passwordSel = By.cssSelector("#password");
    private static By loginBtnSel = By.cssSelector("[type='submit']");
    public static void main(String[] args) throws InterruptedException {
        String username = "tomsmith";
        String password = "SuperSecretPassword!";
        WebDriver driver = DriverFactory.getChromeDriver();
        //open target url
        String loginUrl = baseUrl.concat(loginSlug);
        driver.get(loginUrl);

        // Find username and password element
        try {

            login(driver,username, password);

        }catch (Exception ignored){}
        finally {
            Thread.sleep(3000);
            driver.quit();
        }
        //Quit

    }
    private static void login(WebDriver driver , String username, String password){
        WebElement usernameElement = driver.findElement(usernameSel);
        WebElement passwordElement = driver.findElement(passwordSel);
        WebElement loginBtnElement = driver.findElement(loginBtnSel);
        usernameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginBtnElement.click();
    }
}
