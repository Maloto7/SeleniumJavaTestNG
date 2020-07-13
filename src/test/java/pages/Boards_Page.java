package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.trello.BaseTrello;


public class Boards_Page extends BaseTrello {
    Login_Page loginPage;
    By newBoardLocator = By.xpath("(//div[@class='board-tile mod-add'])[1]");
    By inputTitleLocator = By.cssSelector(".subtle-input");
    By menuTeamLocator = By.linkText("No team");
    By createBoardLocator = By.cssSelector(".button > span:nth-child(2)");
    By menuTeam = By.cssSelector(".org-chooser-trigger > .icon-sm");
    By boarTitleLocator = By.cssSelector(".js-board-editing-target");

//    public Boards_Page(){
//        super(driver);
//    }

    public void createNewBoard(String title){
        waitElementVisible(newBoardLocator);
        click(newBoardLocator);
        type(title,inputTitleLocator);
        waitElementToBeClickable(menuTeam);
        click(menuTeam);
        click(menuTeamLocator);
        click(createBoardLocator);
    }

    public String boarTitle() {
        waitElementVisible(boarTitleLocator);
        return getText(boarTitleLocator);
    }


}


