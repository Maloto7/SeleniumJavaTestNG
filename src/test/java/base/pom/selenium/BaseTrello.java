package base.pom.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.pom.selenium.Base;

public class BaseTrello extends Base{

    By usernameLocator = By.id("user");
    By passwordLocator = By.id("password");
    By loginButtonLocator = By.id("login");
    String userName = "agustin.colque@gmail.com";
    String password = "Coflesto7";

    public BaseTrello(WebDriver driver){
        super(driver);
    }
    public void loginTrello() {

        type(userName,usernameLocator);
        type(password,passwordLocator);
        click(loginButtonLocator);
    }
}
