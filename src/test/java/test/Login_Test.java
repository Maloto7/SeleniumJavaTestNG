package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.Login_Page;

import static junit.framework.TestCase.assertEquals;

public class Login_Test {

    private WebDriver driver;
    private String url;
    Login_Page loginPage;
    String userName = "agustin.colque@gmail.com";
    String password = "Coflesto7";
    String invalidUserName = "agustin.colque001@gmail.com";
    String InvalidPassword = "Coflesto72";


    @Before
    public void setUp(){
        url = "https://trello.com/login";
        loginPage = new Login_Page(driver);
        driver = loginPage.chromeDriverConnection(false);
        driver.manage().window().maximize();
        loginPage.goTo(url);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void successLogin() throws InterruptedException {
        loginPage.loginUser(userName,password);
        assertEquals("AC",loginPage.homeUserName());
    }
    @Test
    public void invalidUserName() throws InterruptedException {
        loginPage.loginUser(invalidUserName,password);
        assertEquals("There isn't an account for this email",loginPage.loginValidationMessage());
    }
    @Test
    public void invalidPassword() throws InterruptedException {
        loginPage.loginUser(userName,InvalidPassword);
        assertEquals("Incorrect email address and / or password. Do you need help logging in?",loginPage.loginValidationMessage());
    }
}

