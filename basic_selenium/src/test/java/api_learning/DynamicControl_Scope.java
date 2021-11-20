package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;
import java.util.List;

public class DynamicControl_Scope implements Urls {
    private static final By inputFieldSel = By.cssSelector("input");
    private static final By btnSel = By.cssSelector("button");
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            // 1st form
            driver.get(baseUrl.concat(dynamicControl));
            By checkBoxExampleForm = By.xpath("//form[@id='checkbox-example']");
            WebElement checkBoxExampleFormElm = driver.findElement(checkBoxExampleForm);
            WebElement checkboxExampleElm = checkBoxExampleFormElm.findElement(inputFieldSel);
            WebElement checkboxExampleBtnElm = checkBoxExampleFormElm.findElement(btnSel);
            if (!checkboxExampleElm.isSelected()) {
                checkboxExampleElm.click();
            }
            checkboxExampleBtnElm.click();
            Thread.sleep(3000);
            //2nd form
            driver.get(baseUrl.concat(dynamicControl));
            By inputExampleForm = By.xpath("//form[@id='input-example']");
            WebElement inputExampleFormElm = driver.findElement(inputExampleForm);
            WebElement inputExampleInoutFieldElm = inputExampleFormElm.findElement(inputFieldSel);
            WebElement inputExampleBtnElm = inputExampleFormElm.findElement(btnSel);
            if (!inputExampleInoutFieldElm.isEnabled())
                inputExampleBtnElm.click();
            Thread.sleep(3000);

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }
    }
}
