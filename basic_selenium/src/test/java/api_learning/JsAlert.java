package api_learning;
import driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;

public class JsAlert implements Urls {
    private static final By jsAlertSel = By.cssSelector("[onclick=\"jsAlert()\"]");
    private static final By jsAlertConfirmSel = By.cssSelector("[onclick=\"jsConfirm()\"]");
    private static final By jsAlertPromptSel = By.cssSelector("[onclick=\"jsPrompt()\"]");
    private static final By resultSel = By.cssSelector("#result");

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to Hovers page
            driver.get(baseUrl.concat(jsAlertPage));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement resultElem = driver.findElement(resultSel);

            // JS ALERT | getText -> confirm
            driver.findElement(jsAlertSel).click();
            Alert jsAlert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println(jsAlert.getText());
            jsAlert.accept();
            System.out.println(resultElem.getText());
            System.out.println("===============");

            // JS ALERT CONFIRM
            driver.findElement(jsAlertConfirmSel).click();
            Alert jsAlertConfirm = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println(jsAlertConfirm.getText());
            jsAlertConfirm.dismiss();
            System.out.println(resultElem.getText());
            System.out.println("===============");

            // JS ALERT PROMPT
            driver.findElement(jsAlertPromptSel).click();
            Alert jsAlertPrompt = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println(jsAlertPrompt.getText());
            jsAlertPrompt.sendKeys("This is my texts...");
            jsAlertConfirm.accept();
            System.out.println(resultElem.getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
