package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;

public class DynamicControls implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(baseUrl.concat(dynamicControl));
            // Link text selector
            By powerByLinkSel = By.linkText("Elemental Selenium");
            WebElement powerByLinkElem = driver.findElement(powerByLinkSel);

            System.out.println("Link Text: "+powerByLinkElem.getText());
            System.out.println("Href: "+powerByLinkElem.getAttribute("href"));
            System.out.println("Target: "+powerByLinkElem.getAttribute("target"));

            // get current url & title
            System.out.println("Current URL: "+ driver.getCurrentUrl());
            System.out.println("Current URL: "+ driver.getTitle());
            // wait strategies
            By checkboxExampleBtnSel = By.xpath("//form[@id='checkbox-example']//button");
            driver.findElement(checkboxExampleBtnSel).click();

            WebElement progressBar = driver.findElement(By.id("loading"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.invisibilityOf(progressBar)); // request per 500ms ->> 500ms .... 20s
            System.out.println("progress bar:"+ progressBar.isDisplayed());

            // click add button again
            driver.findElement(checkboxExampleBtnSel).click();
            // wait a little
            Thread.sleep(3000);

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }
    }
}
