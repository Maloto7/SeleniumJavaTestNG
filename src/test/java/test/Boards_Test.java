package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.Boards_Page;

import static junit.framework.TestCase.assertEquals;

public class Boards_Test {

    private WebDriver driver;
    private String url;
    Boards_Page BoardsPage;
    String userName = "agustin.colque@gmail.com";
    String password = "Coflesto7";

    @Before
    public void setUp(){
        url = "https://trello.com/login";
        BoardsPage = new Boards_Page(driver);
        driver = BoardsPage.chromeDriverConnection(false);
        driver.manage().window().maximize();
        BoardsPage.goTo(url);
        BoardsPage.loginTrello();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void successLogin() throws InterruptedException {
        BoardsPage.createNewBoard("Test Board");
        assertEquals("Test Board",BoardsPage.boarTitle());
    }
}

