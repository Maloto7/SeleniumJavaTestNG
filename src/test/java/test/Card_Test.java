package test;


import base.pom.selenium.enums.Browsers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.List_Page;
import static org.testng.AssertJUnit.*;

public class Card_Test {

    private WebDriver driver;
    private String url;
    List_Page ListPage;
    String userName = "agustin.colque@gmail.com";
    String password = "Password.1";
    String boardName = "test Board";

    @BeforeMethod
    public void setUp(){
        url = "https://trello.com/login";
        ListPage = new List_Page(driver);
        driver = ListPage.driverConnection(Browsers.CHROME,false);
        driver.manage().window().maximize();
        ListPage.goTo(url);
        ListPage.loginTrello(userName,password);
        ListPage.createBoard(boardName);
        ListPage.createNewList("Test List");
    }

    @AfterMethod
    public void tearDown(){
        ListPage.deleteBoard();
        driver.quit();
    }

    @Test
    public void createNewCard() {
        ListPage.createNewCard("Test card");
        assertEquals("Test card",ListPage.cardTitle());

    }

    @Test
    public void changeName() {
        ListPage.createNewCard("Test card");
        ListPage.changeNameCard("Test card2");
        assertEquals("Test card2", ListPage.cardTitle());
    }

}

