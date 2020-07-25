package pages;

import org.openqa.selenium.By;
import base.trello.BaseTrello;
import org.openqa.selenium.WebDriver;


public class List_Page extends BaseTrello {

    By inputTitleLocator = By.cssSelector(".list-name-input");
    By addListLocator = By.cssSelector("input.primary.mod-list-add-button.js-save-edit");
    By listTitleInputLocator = By.cssSelector(".list-header-name.mod-list-name.js-list-name-input");
    By titleListLocator = By.cssSelector(".list-header-target");
    By titleInputListLocator = By.cssSelector(".list-header-name");
    By listMenuLocator = By.cssSelector(".list-header-extras-menu");
    By copyListMenuLocator = By.linkText("Copy List…");
    By titleCopyListMenuLocator = By.cssSelector(".js-autofocus");
    By copyListTitleInputLocator = By.xpath(
            "(//textarea[@class='list-header-name mod-list-name js-list-name-input'])[2]");
    By newCardLocator = By.cssSelector(".js-list:nth-child(1) .js-add-a-card");
    By newCardTitleLocator = By.cssSelector(".list-card-composer-textarea");
    By cardTitleLocator = By.cssSelector(".list-card-title");
    By addCardButtonLocator = By.cssSelector(".confirm");
    By editCardButtonLocator = By.cssSelector(".icon-edit");
    By editCardInputLocator = By.cssSelector(".list-card-edit-title");
    By editCardAcceptLocator = By.cssSelector(".wide");

    public List_Page(WebDriver driver){
        super(driver);
    }


    public void createNewCard(String title){
        waitElementToBeClickable(newCardLocator);
        click(newCardLocator);
        type(title,newCardTitleLocator);
        click(addCardButtonLocator);
    }

    public void createNewList(String title){
        waitElementToBeClickable(inputTitleLocator);
        type(title,inputTitleLocator);
        click(addListLocator);
    }
    public void changeNameList(String title){
        waitElementVisible(titleListLocator);
        click(titleListLocator);
        type(title,titleInputListLocator);
        pressEnterKey(titleInputListLocator);
    }

    public void changeNameCard(String title){
        waitElementVisible(editCardButtonLocator);
        click(editCardButtonLocator);
        type(title,editCardInputLocator);
        pressEnterKey(editCardAcceptLocator);
    }
    public String listTitle() {
        waitElementVisible(listTitleInputLocator);
        return getText(listTitleInputLocator);
    }
    public String copyListTitle() {
        waitElementVisible(copyListTitleInputLocator);
        return getText(copyListTitleInputLocator);
    }
    public String cardTitle() {
        waitElementVisible(cardTitleLocator);
        return getText(cardTitleLocator);
    }
    public void copyListBoard(String title){
        waitElementVisible(listMenuLocator);
        click(listMenuLocator);
        click(copyListMenuLocator);
        type(title,titleCopyListMenuLocator);
        pressEnterKey(titleCopyListMenuLocator);
    }
}


