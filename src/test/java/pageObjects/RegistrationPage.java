package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage
{ 
		public RegistrationPage(WebDriver driver)
		{
			super(driver);
		}
		
		@FindBy(xpath="//input[@id='input-firstname']")
		WebElement txtFirstName;
		
		@FindBy(xpath="//input[@id='input-lastname']")
		WebElement txtLastName;
		
		@FindBy(xpath="//input[@id='input-email']")
		WebElement txtEmail;
		
		@FindBy(xpath="//input[@id='input-telephone']")
		WebElement txtTelephone;
		
		@FindBy(xpath="//input[@id='input-password']")
		WebElement txtPassword;
		
		@FindBy(xpath="//input[@id='input-confirm']")
		WebElement txtConfirmPassword;
		
		@FindBy(xpath="//label[normalize-space()='Yes']")
		WebElement btnYes;
		
		@FindBy(xpath="//input[@name='agree']")
		WebElement chkAgree;
		
		@FindBy(xpath="//input[@value='Continue']")
		WebElement btnContinue;
			
		@FindBy(xpath="//p[text()='Congratulations! Your new account has been successfully created!']")
		WebElement messageConfirmation;
		
		 public void SetFirstName(String FName)
	     {
	    	 txtFirstName.sendKeys(FName);
	     }
		 
		 public void SetLastName(String LName)
	     {
			 txtLastName.sendKeys(LName);
	     }
		 
		 public void SetEmail(String Email)
	     {
			 txtEmail.sendKeys(Email);
	     }
		 
		 public void SetTelephone(String Telephone)
	     {
			 txtTelephone.sendKeys(Telephone);
	     }
		 
		 public void SetPassword(String Password)
	     {
			 txtPassword.sendKeys(Password);
	     }
		 
		 public void SetConfirmPassword(String ConfirmPassword)
	     {
			 txtConfirmPassword.sendKeys(ConfirmPassword);
	     }
		 
		 public void ClkButton()
	     {
			 btnYes.click();
	     }
		 
		 public void Clkcheckbox()
		 {
			 chkAgree.click();
		 }
		 
		 public void ClkContinue()
		 {
			 btnContinue.click();
		 }
		 
		 public String getConfirmationMessage()
		 {
			 try {
       		  return(messageConfirmation.getText());
       	 }
       	 catch(Exception e)
       	 {
       		 return e.getMessage();
       	 }
		 }
}




