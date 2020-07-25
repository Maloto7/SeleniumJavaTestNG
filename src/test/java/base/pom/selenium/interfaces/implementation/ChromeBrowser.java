package base.pom.selenium.interfaces.implementation;

import base.pom.selenium.interfaces.IBrowserConnection;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class  ChromeBrowser implements IBrowserConnection {
    private WebDriver driver;

    public WebDriver driverConnection(Boolean headless) {
//        ystem.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");S
        WebDriverManager.chromedriver().setup();
        if (headless) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else {
            driver = new ChromeDriver();
        }
        return driver;
    }
}
