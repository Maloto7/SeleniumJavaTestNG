package base.pom.selenium;

import base.pom.selenium.enums.Browsers;
import base.pom.selenium.interfaces.implementation.ChromeBrowser;
import base.pom.selenium.interfaces.IBrowserConnection;
import base.pom.selenium.interfaces.implementation.EdgeBrowser;
import base.pom.selenium.interfaces.implementation.FireFoxBrowser;
import base.pom.selenium.interfaces.implementation.OperaBrowser;

import static base.pom.selenium.enums.Browsers.*;

public class BrowserFactory {
    public IBrowserConnection getBrowserConnection(Browsers browser) {
        switch (browser) {
            case CHROME:
                return new ChromeBrowser();
            case FIREFOX:
                return new FireFoxBrowser();
            case OPERA:
                return new OperaBrowser();
            case EDGE:
                return new EdgeBrowser();
            default:
                System.out.println("no browser selected");
                return (null);
        }
    }
}
