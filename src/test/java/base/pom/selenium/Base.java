package base.pom.selenium;
import base.pom.selenium.interfaces.IBrowserConnection;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.peer.SystemTrayPeer;
import java.util.List;
import base.pom.selenium.enums.Browsers;


public class Base {
    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;


    public WebDriver driverConnection(Browsers browser, Boolean headless){

        try {
            BrowserFactory browserConnection = new BrowserFactory();
            IBrowserConnection browserDriver = browserConnection.getBrowserConnection(browser);
            this.driver = browserDriver.driverConnection(headless);
            this.actions = new Actions(driver);
            this.wait = new WebDriverWait(driver,30);
        }catch (Exception e){
            System.out.println("The message is: " + e.getMessage());
            System.out.println("The cause is: " + e.getCause() );
            e.printStackTrace();
        }
        return driver;
    }

    public void moveToElement(By locator){
        actions.moveToElement(driver.findElement(locator))
                .perform();
    }

    public void changeTab(int indexTab){
        String[] browserTibSize = driver.getWindowHandles().toArray(new String[0]);
        driver.switchTo().window(browserTibSize[indexTab]);
    }

    public void alertAccept() {
        driver.switchTo().alert().accept();
    }

    public void alertDismiss() {
        driver.switchTo().alert().dismiss();
    }

    public String getAlertMessage() {
        return driver.switchTo().alert().getText();
    }

    public void jsClick(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",driver.findElement(locator));
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public void dragAndDropElement(By locatorDrag, By locatorDrop){
        actions.dragAndDrop(driver.findElement(locatorDrag),driver.findElement(locatorDrop))
                .perform();
    }

    public void datePicker(By locator, String date){
        driver.findElement(locator).sendKeys(date);
        driver.findElement(locator).sendKeys(Keys.RETURN);

    }

    public void waitElementVisible(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitElementToBeClickable(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }
    public void typeInFrame(String inputText, By locator){

        driver.switchTo().frame(0);
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void click(WebElement element){
        element.click();
    }
    public void pressEnterKey(By locator){
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    public Boolean isDisplayed(By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }
    public Boolean isEnable(By locator){
        return driver.findElement(locator).isEnabled();
    }

    public void goTo(String url){
        driver.get(url);
    }



}
