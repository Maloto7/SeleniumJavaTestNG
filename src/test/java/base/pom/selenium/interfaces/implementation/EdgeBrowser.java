package base.pom.selenium.interfaces.implementation;

import base.pom.selenium.interfaces.IBrowserConnection;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class EdgeBrowser implements IBrowserConnection {
    private WebDriver driver;

    public WebDriver driverConnection(Boolean headless) {
//        System.setProperty("webdriver.edge.driver","./src/test/resources/edgeDriver/msedgedriver.exe");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        return driver;
    }
}
