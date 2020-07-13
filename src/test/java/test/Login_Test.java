package test;

import base.pom.selenium.enums.Browsers;
import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.Login_Page;

import static org.testng.AssertJUnit.*;
//@Listeners(base.pom.selenium.listeners.TestNGListeners.class)
public class Login_Test {

    private WebDriver driver;
    private String url;
    Login_Page loginPage;
    String userName = "agustin.colque@gmail.com";
    String password = "Coflesto7";
    String invalidUserName = "agustin.colque001@gmail.com";
    String InvalidPassword = "Coflesto72";

    @BeforeMethod
    public void setUp() {
        url = "https://trello.com/login";
        loginPage = new Login_Page();
        driver = loginPage.driverConnection(Browsers.CHROME, true);
        driver.manage().window().maximize();
        loginPage.goTo(url);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void successLogin() throws Exception {
        loginPage.loginUser(userName, password);
        assert "AC".equals(loginPage.homeUserName());
    }

    @Test
    public void invalidUserName() throws InterruptedException {
        loginPage.loginUser(invalidUserName, password);
        assertEquals("There isn't an account for this email",
                loginPage.loginValidationMessage());
    }

    @Test
    public void invalidPassword()  {
        loginPage.loginUser(userName, InvalidPassword);
        assertEquals("Incorrect email address and / or password. Do you need help logging in?",
                loginPage.loginValidationMessage());
    }

}

