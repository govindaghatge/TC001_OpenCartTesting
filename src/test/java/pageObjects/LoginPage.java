package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	  
	  public LoginPage(WebDriver driver)
	  {
		  super(driver);
	  }
	  
	  @FindBy(xpath="//input[@name='email']")
	  WebElement txtEmail;
	  
	  @FindBy(xpath="//input[@name='password']")
	  WebElement txtPassword;
	  
	  @FindBy(xpath="//input[@type='submit']")
	  WebElement clkLogin;
	  
	  public void SetEmail(String email)
	  {
		  txtEmail.sendKeys(email);
	  }
	  
	  public void SetPassword(String password)
	  {
		  txtPassword.sendKeys(password);
	  }
	  
	  public void ClkLogin()
	  {
		  clkLogin.click();  
	  }
	  
}