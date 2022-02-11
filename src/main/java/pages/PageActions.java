package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class PageActions {
    private WebDriver webDriver;
    private PageWaits pageWaits;
    public PageActions(WebDriver driver) {
        this.webDriver=driver;
        this.pageWaits=new PageWaits(driver);
    }
    public void click(By by){
        pageWaits.waitForElementToBeVisible(by).click();
    }
    public void type(By by, String value){
        pageWaits.waitForElementToBeVisible(by).sendKeys(value);
    }
    public String getChildText(WebElement webElement, By by){
        return webElement.findElement(by).getText();
    }
    public String getPageTitle(){
        return this.webDriver.getTitle();
    }
    public JavascriptExecutor jsDriver() {
        return ((JavascriptExecutor) this.webDriver);
    }
    public String getCurrentPageUrl(){
        return this.webDriver.getCurrentUrl();
    }
    public void quit(){
        this.webDriver.quit();
    }
    public void close(){
        this.webDriver.close();
    }
    public WebElement findElement(By by){
        return this.webDriver.findElement(by);
    }
    public List<WebElement> findElements(By by){
        return this.webDriver.findElements(by);
    }
    public void deleteCookies(){
        this.webDriver.manage().deleteAllCookies();
    }

}
