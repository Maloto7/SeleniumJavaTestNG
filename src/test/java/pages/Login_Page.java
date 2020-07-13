package pages;

import base.trello.BaseTrello;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Page extends BaseTrello {

    By usernameLocator = By.id("user");
    By passwordLocator = By.id("password");
    By loginButtonLocator = By.id("login");
    By userNameLocator = By.xpath("//div[@title='agustin colque (agustincolque)']/span");
    By wrongCredentialsLocator = By.xpath("//div[@class='quick-switch']");

//    public Login_Page(WebDriver driver){
//        super(driver);
//    }
    public void loginUser(String userName, String password) {

        if(isDisplayed(loginButtonLocator)){
            type(userName,usernameLocator);
            type(password,passwordLocator);
            click(loginButtonLocator);
        }else {
            System.out.println("Register Page was not fount");
        }
    }

    public String homeUserName() throws InterruptedException {
        waitElementVisible(userNameLocator);
        return getText(userNameLocator);
    }
    public String loginValidationMessage()  {
        waitElementVisible(wrongCredentialsLocator);
        return getText(wrongCredentialsLocator);
    }


}

