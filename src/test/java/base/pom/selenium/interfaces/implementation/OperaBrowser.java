package base.pom.selenium.interfaces.implementation;
import base.pom.selenium.interfaces.IBrowserConnection;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.opera.OperaDriver;


public class OperaBrowser implements IBrowserConnection {
    private WebDriver driver;

    public WebDriver driverConnection(Boolean headless) {
//        System.setProperty("webdriver.opera.driver","./src/test/resources/operaDriver/operadriver.exe");
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
        return driver;
    }
}
