package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import url.Urls;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class MouseHover implements Urls {
    private static final By figureSel = By.className("figure");
    private static final By figureImgSel = By.tagName("img");
    private static final By figureDescSel = By.tagName("h5");
    private static final By figureImgLinkSel = By.tagName("a");

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to Hovers page
            driver.get(baseUrl.concat(hovers));
            List<WebElement> figureElems = driver.findElements(figureSel);
            List<FigureData> figuresData = new ArrayList<>();
            Actions actions = new Actions(driver);

            // Get Figure data from UI
            if (figureElems.isEmpty())
                throw new RuntimeException("No figures on the page");
            else {
                for (WebElement figureElem : figureElems) {
                    // Mouse hover
                    actions.moveToElement(figureElem).perform();

                    // Get each figure data
                    WebElement figureImgElem = figureElem.findElement(figureImgSel);
                    String figureImgSrc = figureImgElem.getAttribute("src");
                    WebElement figureDescElem = figureElem.findElement(figureDescSel);
                    String figureDesc = figureDescElem.getText();
                    WebElement figureImgLinkElem = figureElem.findElement(figureImgLinkSel);
                    String figureImgLink = figureImgLinkElem.getAttribute("href");

                    FigureData figureData = new FigureData(figureImgSrc, figureDesc, figureImgLink);
                    figuresData.add(figureData);
                }
            }

            // Verify Figures data
            for (FigureData figureData : figuresData) {
                System.out.println(figureData);
            }

            // Randomly pick up
            WebElement randomUserAvatarElem = figureElems.get(new SecureRandom().nextInt(figureElems.size()));
            actions.moveToElement(randomUserAvatarElem).perform();
            WebElement userProfileLinkElem = randomUserAvatarElem.findElement(figureImgLinkSel);
            userProfileLinkElem.click();

            // Tag name h1
            System.out.println(driver.findElement(By.tagName("h1")).getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public static class FigureData {
        private String imgSrc;
        private String imgDesc;
        private String imgLink;

        public FigureData(String imgSrc, String imgDesc, String imgLink) {
            this.imgSrc = imgSrc;
            this.imgDesc = imgDesc;
            this.imgLink = imgLink;
        }

        public String imgSrc() {
            return imgSrc;
        }

        public String imgDesc() {
            return imgDesc;
        }

        public String imgLink() {
            return imgLink;
        }

        @Override
        public String toString() {
            return "FigureData{" +
                    "imgSrc='" + imgSrc + '\'' +
                    ", imgDesc='" + imgDesc + '\'' +
                    ", imgLink='" + imgLink + '\'' +
                    '}';
        }
    }
}
