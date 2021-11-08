package test;

import base.pom.selenium.enums.Browsers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.*;
import static org.testng.AssertJUnit.*;
//@Listeners(base.pom.selenium.listeners.TestNGListeners.class)

public class Login_Test {

    private WebDriver driver;
    private String url;
    public static LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        url = "http://qa-trainingw7:86/default.aspx";
        loginPage = new LoginPage(driver);
        driver = loginPage.driverConnection(Browsers.CHROME, false);
        driver.manage().window().maximize();
        loginPage.goTo(url);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void passTest() {
        loginPage.login("asfasd000", "adsf123");
        assertEquals(true,loginPage.logingErrorDisplayed("Your login attempt was not successful. Please try again."));
    }

    @Test
    public void failTest() {
        loginPage.login("asfasd000", "adsf123");
        assertEquals(true,loginPage.logingErrorDisplayed("Your2 login attempt was not successful. Please try again."));
    }
}

