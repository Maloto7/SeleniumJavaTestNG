package test;


import base.pom.selenium.enums.Browsers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.Boards_Page;

import static org.testng.AssertJUnit.*;

public class Boards_Test {

    private WebDriver driver;
    private String url;
    Boards_Page BoardsPage;
    String userName = "agustin.colque@gmail.com";
    String password = "Password.1";

    @BeforeMethod
    public void setUp() {
        url = "https://trello.com/login";
        BoardsPage = new Boards_Page(driver);
        driver = BoardsPage.driverConnection(Browsers.CHROME, false);
        driver.manage().window().maximize();
        BoardsPage.goTo(url);
        BoardsPage.loginTrello(userName, password);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void createNewBoard() {
        BoardsPage.createNewBoard("Test Board");
        assertEquals("Test Board", BoardsPage.boarTitle());
        BoardsPage.deleteBoard();
    }

    @Test
    public void changeBoardName() {
        BoardsPage.createBoard("Test Board");
        BoardsPage.changeNameBoard("Test Board2");
        assertEquals("Test Board2", BoardsPage.boarTitle());
        BoardsPage.deleteBoard();
    }

    @Test
    public void addBoardButtonStatusDisable() {
        assertFalse(BoardsPage.boardButtonIsEnable());
    }
}

