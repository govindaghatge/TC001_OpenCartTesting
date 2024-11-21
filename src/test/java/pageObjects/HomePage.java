package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
     public HomePage(WebDriver driver)
     {
    	 super(driver);
     }
     
     @FindBy(xpath="//span[text()='My Account']")
     WebElement ClkAccount;
     
     @FindBy(xpath="//a[text()='Register']")
     WebElement ClkRegister;
     
     @FindBy(xpath="(//a[normalize-space()='Login'])[1]")
     WebElement ClkLogin;
     
     public void MyAccount()
     {
    	 ClkAccount.click();
     }
     
     public void MyRegister()
     {
    	 ClkRegister.click();
     }
     
     public void MyLogin()
     {
    	 ClkLogin.click();
     }
}
