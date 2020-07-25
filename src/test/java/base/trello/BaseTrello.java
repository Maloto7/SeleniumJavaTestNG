package base.trello;
import org.openqa.selenium.By;
import base.pom.selenium.Base;
import org.openqa.selenium.WebDriver;

public class BaseTrello extends Base{

    By usernameLocator = By.id("user");
    By passwordLocator = By.id("password");
    By loginButtonLocator = By.id("login");
    By newBoardLocator = By.xpath("(//div[@class='board-tile mod-add'])[1]");
    By inputTitleLocator = By.cssSelector(".subtle-input");
    By menuTeamLocator = By.linkText("No team");
    By createBoardLocator = By.cssSelector(".button > span:nth-child(2)");
    By menuTeam = By.cssSelector(".org-chooser-trigger > .icon-sm");
    By moreActionsLocator = By.cssSelector(".js-open-more");
    By closeBoardLocator = By.linkText("Close Board…");
    By confirmLocator = By.cssSelector(".js-confirm");
    By deleteBoardLocator = By.linkText("Permanently Delete Board…");

    public BaseTrello(WebDriver driver){
        super(driver);
    }
    public void loginTrello(String userName , String password) {

        type(userName,usernameLocator);
        type(password,passwordLocator);
        click(loginButtonLocator);
    }
    public void deleteBoard() {
        waitElementToBeClickable(moreActionsLocator);
        click(moreActionsLocator);
        waitElementToBeClickable(closeBoardLocator);
        click(closeBoardLocator);
        click(confirmLocator);
        waitElementToBeClickable(deleteBoardLocator);
        click(deleteBoardLocator);
        click(confirmLocator);
    }
    public void createBoard(String title){
        waitElementVisible(newBoardLocator);
        click(newBoardLocator);
        waitElementToBeClickable(inputTitleLocator);
        type(title,inputTitleLocator);
        waitElementToBeClickable(menuTeam);
        click(menuTeam);
        click(menuTeamLocator);
        click(createBoardLocator);
    }

}
