package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyaccountPage extends BasePage
{
            public MyaccountPage(WebDriver driver)
            {
            	super(driver);
            }
            
            @FindBy(xpath="//h2[text()='My Account']")
            WebElement LoginConfirmation;
            
            @FindBy(xpath="//a[@class='list-group-item'][text()='Logout']")
            WebElement ClkLogout;
            
            public boolean getLoginConfirmation()
            {
            	try
            	{
            		return (LoginConfirmation.isDisplayed());
            	}
            	catch(Exception e)
            	{
            		return false;
            	}
            }
            
            public void ClkLogout()
            {
            	ClkLogout.click();
            }
}
