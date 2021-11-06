package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.pom.selenium.Base;

public class LoginPage  extends Base {

	By LoginLink = By.id("ctl00_LoginView_LoginLink");
	By UserNameTxtBox = By.id("ctl00_Main_LoginConrol_UserName");
	By PasswordTxtBox = By.id("ctl00_Main_LoginConrol_Password");
	By LoginAttemptMessage = By.xpath("//table[@id='ctl00_Main_LoginConrol']/tbody/tr/td/table/tbody/tr[4]/td");
	By LoginButton = By.id("ctl00_Main_LoginConrol_LoginButton");

	// Set the diver instance.
	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}
	
	public void login(String userName, String password)
	{
		click(LoginLink);
		type(userName,UserNameTxtBox);
		type(password,PasswordTxtBox);
		click(LoginButton);
	}
	
	public boolean logingErrorDisplayed(String loginError) //sacar el loging
	{
		return getText(LoginAttemptMessage).equals(loginError);
	}

}
