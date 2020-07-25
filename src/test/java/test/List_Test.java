package test;


import base.pom.selenium.enums.Browsers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.List_Page;
import static org.testng.AssertJUnit.*;

public class List_Test {

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
    }

    @AfterMethod
    public void tearDown(){
        ListPage.deleteBoard();
        driver.quit();
    }

    @Test
    public void createNewList() {
        ListPage.createNewList("Test List");
        assertEquals("Test List",ListPage.listTitle());
    }

    @Test
    public void copyList() {
        ListPage.createNewList("Test list");
        ListPage.copyListBoard("copy list");;
        assertEquals("copy list", ListPage.copyListTitle());
    }
}

