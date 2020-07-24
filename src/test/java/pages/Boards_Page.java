package pages;

import org.openqa.selenium.By;
import base.trello.BaseTrello;


public class Boards_Page extends BaseTrello {
    By newBoardLocator = By.xpath("(//div[@class='board-tile mod-add'])[1]");
    By inputTitleLocator = By.cssSelector(".subtle-input");
    By menuTeamLocator = By.linkText("No team");
    By createBoardLocator = By.cssSelector(".button");
    By menuTeam = By.cssSelector(".org-chooser-trigger > .icon-sm");
    By boardTitleLocator = By.cssSelector(".js-board-editing-target");
    By boardTitleInputLocator = By.cssSelector(".board-name-input");

    public void createNewBoard(String title){
        waitElementVisible(newBoardLocator);
        click(newBoardLocator);
        type(title,inputTitleLocator);
        waitElementToBeClickable(menuTeam);
        click(menuTeam);
        click(menuTeamLocator);
        click(createBoardLocator);
    }

    public Boolean boardButtonIsEnable(){
        waitElementVisible(newBoardLocator);
        click(newBoardLocator);
        waitElementToBeClickable(menuTeam);
        click(menuTeam);
        click(menuTeamLocator);
        return isEnable(createBoardLocator);
    }

    public void changeNameBoard(String title){
        waitElementVisible(boardTitleLocator);
        click(boardTitleLocator);
        type(title,boardTitleInputLocator);
        pressEnterKey(boardTitleInputLocator);
    }




    public String boarTitle() {
        waitElementVisible(boardTitleLocator);
        return getText(boardTitleLocator);
    }


}


