package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;
import java.util.List;

public class DynamicControl_SelectObjectByList implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(baseUrl.concat(dynamicControl));
            // Link text selector
            By btnSel = By.xpath("//button");
            List<WebElement> btnElms = driver.findElements(btnSel);
            System.out.println("Size: "+btnElms.size());
            final int CHECKBOX_EXAMPLE_BTN_INDEX =0;
            final int INPUT_EXAMPLE_BTN_INDEX =1;
            WebElement checkBoxExampleBtnIndex = btnElms.get(CHECKBOX_EXAMPLE_BTN_INDEX);
            WebElement inputExampleBtnIndex = btnElms.get(INPUT_EXAMPLE_BTN_INDEX);
            checkBoxExampleBtnIndex.click();
            inputExampleBtnIndex.click();

            Thread.sleep(3000);

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }
    }
}
